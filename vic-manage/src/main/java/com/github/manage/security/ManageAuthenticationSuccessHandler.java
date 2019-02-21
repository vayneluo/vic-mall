package com.github.manage.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.manage.common.enums.LogTypeEnum;
import com.github.manage.common.util.AddressUtil;
import com.github.manage.common.util.CommonConstants;
import com.github.manage.entity.manage.SysLog;
import com.github.manage.repository.manage.SysLogMapper;
import com.github.manage.result.GeneralResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.security
 * @Description: 后台登录成功处理器
 * @Author: Vayne.Luo
 * @date 2018/12/27
 */
@Slf4j
@Component
public class ManageAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    @Autowired
    SysLogMapper sysLogMapper;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //this.redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/hello");
        WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) authentication.getDetails();
        ManageUserDetails manageUserDetails = (ManageUserDetails) authentication.getPrincipal();
        manageUserDetails.setRemoteAddress(webAuthenticationDetails.getRemoteAddress());
        //保存用户登录日志
        saveLoginLog(manageUserDetails);
        log.info("登录成功，用户 {}",manageUserDetails.getUsername());
        httpServletResponse.setContentType(CommonConstants.JSON_UTF8);
        httpServletResponse.getWriter().write(mapper.writeValueAsString(new GeneralResult()));
    }

    /**
     * 登录成功后记录登录日志
     * @param manageUserDetails 登录用户信息
     */
    @Async
    @Transactional
    public void saveLoginLog(ManageUserDetails manageUserDetails) {
        SysLog sysLog = new SysLog();
        sysLog.setUsername(manageUserDetails.getUsername());   //操作用户
        sysLog.setIp(manageUserDetails.getRemoteAddress());    //IP
        sysLog.setLogType(LogTypeEnum.LOGIN_LOG.getType());    //日志类型
        sysLog.setOperation("登录后台系统");
        sysLog.setLocation(AddressUtil.getCityInfo(manageUserDetails.getRemoteAddress()));
        sysLogMapper.insert(sysLog);
    }
}
