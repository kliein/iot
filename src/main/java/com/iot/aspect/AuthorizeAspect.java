package com.iot.aspect;


import com.iot.constant.CookieConstant;
import com.iot.exception.UserAuthorizeException;
import com.iot.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class AuthorizeAspect {


    @Pointcut("execution(public * com.iot.controller.I*.*(..))"+
            "&& !execution(public * com.iot.controller.AdminController.*(..))")
    public void verify(){}



    @Before("verify()")
    public void doverify() throws UserAuthorizeException {
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        //查询cookie

        Cookie cookie=CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie==null){
            log.warn("【登陆校验】cookie中查不到token");
            throw new UserAuthorizeException();
        }
        log.info("【cookie】:{}",cookie.getValue());

    }
}
