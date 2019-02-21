package com.github.manage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.manage.common.annotation.Log;
import com.github.manage.common.properties.FastAdminProperties;
import com.github.manage.result.DataResult;
import com.github.manage.result.GeneralResult;
import com.github.manage.result.Result;
import com.github.manage.vo.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.controller
 * @Description: 登录控制器
 * @Author: Vayne.Luo
 * @date 2018/12/26
 */
@RestController
@Slf4j
public class LoginController {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    FastAdminProperties fastAdminProperties;

    /**
     * 跳转首页
     */
    @GetMapping("/index")
    public GeneralResult index(HttpServletRequest request,HttpServletResponse response) throws IOException{
        return new GeneralResult();
    }

    /**
     * 跳转首页
     */
    @GetMapping("/")
    public void success(HttpServletRequest request,HttpServletResponse response) throws IOException{
        redirectStrategy.sendRedirect(request,response,fastAdminProperties.getSecurity().getIndexUrl());
    }

    @Log("访问主页")
    @GetMapping("/dashboard")
    public DataResult<SysUserVo> index(HttpServletRequest request) {
        //int i = 1/0;
        SysUserVo sysUserVo = new SysUserVo();
        sysUserVo.setUsername("vayne");
        return new DataResult<>(sysUserVo);
    }

    @GetMapping("/login-page")
    public Result login(HttpServletRequest request, HttpServletResponse response) {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String redirectUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是：{}", redirectUrl);
        }
        return Result.error401("请登录","登录失败");
    }
}
