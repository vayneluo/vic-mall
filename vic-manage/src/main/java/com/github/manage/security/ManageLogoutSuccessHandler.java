package com.github.manage.security;

import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.security
 * @Description: 登出成功后，清除session信息
 * @Author: Vayne.Luo
 * @date 2018/12/29
 */
@Data
public class ManageLogoutSuccessHandler implements LogoutHandler{

    private SessionRegistry sessionRegistry;

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        String sessionId = httpServletRequest.getRequestedSessionId();
        if(null != sessionId){
            sessionRegistry.removeSessionInformation(sessionId);
        }
    }
}
