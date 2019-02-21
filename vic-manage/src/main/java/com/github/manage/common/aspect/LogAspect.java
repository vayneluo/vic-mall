package com.github.manage.common.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.manage.common.annotation.Log;
import com.github.manage.common.enums.LogTypeEnum;
import com.github.manage.common.properties.FastAdminProperties;
import com.github.manage.common.util.AddressUtil;
import com.github.manage.common.util.HttpContextUtil;
import com.github.manage.common.util.SecurityUtil;
import com.github.manage.entity.manage.SysLog;
import com.github.manage.repository.manage.SysLogMapper;
import com.github.manage.security.ManageUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.aspect
 * @Description: 记录用户操作日志
 * @Author: Vayne.Luo
 * @date 2018/12/27
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    FastAdminProperties fastAdminProperties;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    SysLogMapper sysLogMapper;

    @Pointcut("@annotation(com.github.manage.common.annotation.Log)")
    public void pointCut(){
        //todo
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws IOException{
        Object result = null;
        //记录开始时间
        long beginTime = System.currentTimeMillis();
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
        }
        //耗时
        long totalTime = System.currentTimeMillis() - beginTime;
        HttpServletRequest request = HttpContextUtil.getServletRequest();
        //操作日志开关
        if(fastAdminProperties.isOpenAopLog()){
            //保存操作日志
            this.saveAopLog(point,totalTime,request.getRemoteAddr());
        }
        return result;
    }

    /**
     * 记录操作日志
     * @param point ProceedingJoinPoint
     * @param totalTime 耗时
     * @param remoteAddr IP
     */
    @Async
    @Transactional
    public void saveAopLog(ProceedingJoinPoint point, long totalTime, String remoteAddr) throws IOException{
        ManageUserDetails details = SecurityUtil.getCurrentUserDetails();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        sysLog.setUsername(details.getUsername());
        sysLog.setIp(remoteAddr);
        sysLog.setLogType(LogTypeEnum.METHOD_LOG.getType());
        sysLog.setTime(totalTime);
        sysLog.setLocation(AddressUtil.getCityInfo(remoteAddr));
        //类名+方法名
        sysLog.setMethod(point.getTarget().getClass().getName() + "." + signature.getName() + "()");
        Log sysLogAnnotation = method.getAnnotation(Log.class);
        if(null != sysLogAnnotation){
            sysLog.setOperation(sysLogAnnotation.value());
        }
        Object[] args = point.getArgs();
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] params = discoverer.getParameterNames(method);
        if(null != args && null != params){
            StringBuilder builder = new StringBuilder();
            this.dealParams(builder,args, Arrays.asList(params));
            sysLog.setParams(builder.toString());
        }
        this.sysLogMapper.insertSelective(sysLog);
    }

    /**
     * 拼接参数
     * @param builder 拼接字符
     * @param args 方法参数值
     * @param params 方法参数名
     */
    private StringBuilder dealParams(StringBuilder builder, Object[] args, List params) throws IOException{
        for(int i = 0; i<args.length;i++){
            if(args[i] instanceof Map){
                Set set = ((Map)args[i]).keySet();
                List list = new ArrayList<>();
                List paramList = new ArrayList();
                for(Object key : set){
                    list.add(((Map)args[i]).get(key));
                    paramList.add(key);
                    return dealParams(builder,list.toArray(),paramList);
                }
            }else{
                if(args[i] instanceof Serializable){
                    Class<?> clazz = args[i].getClass();
                    try {
                        //根据是否实现toString方法处理
                        clazz.getDeclaredMethod("toString",new Class[]{null});
                        builder.append("  ").append(params.get(i)).append(":  ").append(objectMapper.writeValueAsString(args[i]));
                    } catch (NoSuchMethodException e) {
                        builder.append("  ").append(params.get(i)).append(":  ").append(objectMapper.writeValueAsString(args[i]).toString());
                    }
                }else if(args[i] instanceof MultipartFile){
                    MultipartFile file = (MultipartFile) args[i];
                    builder.append("  ").append(params.get(i)).append(": ").append(file.getName());
                }else{
                    builder.append("  ").append(params.get(i)).append(": ").append(args[i]);
                }
            }
        }
        return builder;
    }

}
