package com.github.manage.config;

import com.github.manage.common.properties.FastAdminProperties;
import com.github.manage.jwt.JwtAuthenticationTokenFilter;
import com.github.manage.security.ManageAuthenticationSuccessHandler;
import com.github.manage.security.ManageLogoutSuccessHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.config
 * @Description: 认证配置
 * @Author: Vayne.Luo
 * @date 2018/12/18
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    //@Autowired
    //private JwtUserDetailService jwtUserDetailService;
    //@Autowired
    //private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    ManageUserDetailService manageUserDetailService;
    @Autowired
    ManageAuthenticationSuccessHandler manageAuthenticationSuccessHandler;
    @Autowired
    FastAdminProperties fastAdminProperties;

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils
                .splitByWholeSeparatorPreserveAllTokens(fastAdminProperties.getSecurity().getAnonUrls(),",");
        http.formLogin()
                //处理登录
                .loginPage(fastAdminProperties.getSecurity().getLoginUrl()) //登录页
                .loginProcessingUrl(fastAdminProperties.getSecurity().getLoginProcessingUrl())  //登录认证路径
                .successHandler(manageAuthenticationSuccessHandler) //登录成功处理器
            .and()
                //处理登出
                .logout()
                .logoutUrl(fastAdminProperties.getSecurity().getLogoutUrl())    //登录路径
                .logoutSuccessUrl("/")  //登出成功后跳转路径
                .addLogoutHandler(logoutSuccessHandler())
                .deleteCookies("JSESSIONID")    //删除JSESSIONID
            .and()
                .authorizeRequests()
                //放行所有预检请求
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers(anonUrls)  //免认证路径
                .permitAll()
                .antMatchers(fastAdminProperties.getSecurity().getLoginUrl())
                .permitAll()
                .anyRequest()   //其他所有路径均需要认证
                .authenticated()
            .and().cors()
            .and().csrf().disable();


        //.headers().cacheControl()
        //http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        //让Spring security放行所有preflight request
        //registry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();
    }

    /**
     * 登出处理器
     */
    @Bean
    public LogoutHandler logoutSuccessHandler() {
        ManageLogoutSuccessHandler handler = new ManageLogoutSuccessHandler();
        handler.setSessionRegistry(sessionRegistry());
        return handler;
    }

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }

    /**
     * 跨域处理
     */
    /*@Bean
    public FilterRegistrationBean corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowCredentials(true);
        cors.addAllowedOrigin("*");
        cors.addAllowedHeader("*");
        cors.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", cors);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(urlBasedCorsConfigurationSource));
        bean.setOrder(0);
        return bean;
    }*/

    /**
     * 自定义登录实现
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.manageUserDetailService).passwordEncoder(passwordEncoder());
    }

    /**
     * 密码加密器
     */
    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
