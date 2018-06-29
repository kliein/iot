package com.iot.util;

import com.iot.constant.CookieConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CookieUtil {

    //**设置cookie*/
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           Integer maxAge){
        Cookie cookie=new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);

    }


    //获取cookie
    public static Cookie get(HttpServletRequest request,
                           String name){
        Map<String,Cookie> cookieHashMap=readCookieMp(request,name);
        if(cookieHashMap.containsKey(name)){
            return cookieHashMap.get(name);
        }
        else {
            return null;
        }


    }

    private static Map<String,Cookie> readCookieMp(HttpServletRequest request,
                                            String name){
        Map<String,Cookie> cookieHashMap=new HashMap<>();
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                cookieHashMap.put(cookie.getName(),cookie);
            }
        }
        return cookieHashMap;
    }

    public static String getCookie(){
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        //查询cookie

        Cookie cookie=CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie==null){
            log.warn("【登陆校验】cookie中查不到token");

        }
        log.info("【cookie】:{}",cookie.getValue());
        return cookie.getValue();
    }
}
