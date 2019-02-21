package com.github.manage.jwt;

import com.github.manage.config.JwtUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.jwt
 * @Description: JWT认证拦截器
 * @Author: Vayne.Luo
 * @date 2018/12/20
 */
@Slf4j
//@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter{

    @Autowired
    JwtUserDetailService userDetailService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String authHeader = request.getHeader(jwtTokenUtil.getHeader());

        log.info("authHeader: {}",authHeader);
        //验证token是否存在
        if(StringUtils.isNotBlank(authHeader)){
            String username = jwtTokenUtil.getUsernameFromToken(authHeader);
            if(null != username && null == SecurityContextHolder.getContext().getAuthentication()){
                UserDetails userDetails = this.userDetailService.loadUserByUsername(username);

                //验证token与用户是否匹配
                if(jwtTokenUtil.verifyToken(authHeader,userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }

            }
        }
        filterChain.doFilter(request,response);
    }
}
