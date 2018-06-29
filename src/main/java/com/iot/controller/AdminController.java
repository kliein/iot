package com.iot.controller;


import com.iot.constant.CookieConstant;
import com.iot.constant.User;
import com.iot.entity.CompanyInfo;
import com.iot.entity.UserInfo;
import com.iot.enums.ResultEnum;
import com.iot.form.RegisterForm;
import com.iot.service.CompanyInfoService;
import com.iot.service.UserInfoService;
import com.iot.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@RequestMapping(value = "/admin")
@Controller
@Slf4j
public class AdminController {

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/login")
    public ModelAndView login(){
       // log.info("【进入login方法】");
        return new ModelAndView("admin/login");
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@Valid RegisterForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map,
                             HttpServletResponse response){
       // log.info("【进入save方法】");
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/iot/admin/login");
            return new ModelAndView("common/error",map);
        }

        UserInfo userInfo=new UserInfo();
        try {
            userInfo=userInfoService.findByUserNameIn(form.getUserName());
        }
        catch (Exception e){
            log.error("【save】：{}",e.getMessage());
            map.put("msg",e.getMessage());
            map.put("url","/iot/admin/login");
            return new ModelAndView("common/error",map);
        }
        if(userInfo==null){
            map.put("msg",ResultEnum.PASS_WORD_ERROR.getMessage());
            map.put("url","/iot/admin/login");
            return new ModelAndView("common/error",map);
        }
        if((userInfo.getUserPassWord()).equals(form.getPassWord())==false){
            map.put("msg",ResultEnum.PASS_WORD_ERROR.getMessage());
            map.put("url","/iot/admin/login");
            return new ModelAndView("common/error",map);
        }
        String token=userInfo.getUserSerialNumber();//UUID
        Integer expire=CookieConstant.EXPIRE;//过期时间
        CookieUtil.set(response,CookieConstant.TOKEN,token,expire);

        User.userName=userInfo.getUserName();
        User.serialNumber =userInfo.getUserSerialNumber();


        return new ModelAndView("redirect:/test/list");
    }

    @PostMapping(value = "/register")
    @Transactional
    public ModelAndView register(@Valid RegisterForm form,
                                 BindingResult bindingResult,
                                 Map<String,Object> map){

     //   log.info("【form】{}",form.getSerialNumber());
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/iot/admin/login");
            return new ModelAndView("common/error",map);
        }

         UserInfo res= userInfoService.findByUserNameIn(form.getUserName());
           if(res!=null){
               map.put("msg",ResultEnum.USER_ALREADY_EXIST.getMessage());
               map.put("url","/iot/admin/login");
               return new ModelAndView("common/error",map);
           }


        CompanyInfo companyInfo=new CompanyInfo();

        try {
            companyInfo=companyInfoService.findBySerialNumberIn(form.getSerialNumber());
        }
        catch (Exception e){
            map.put("msg",e.getMessage());
            map.put("url","/iot/admin/login");
            return new ModelAndView("common/error",map);
        }

        if(companyInfo==null){
            map.put("msg",ResultEnum.AUTHORIZATION_INCORRECT.getMessage());
            map.put("url","/iot/admin/login");
            return new ModelAndView("common/error",map);
        }

        if(companyInfo.getIsOverdue()==1){
            map.put("msg",ResultEnum.AUTHORIZATION_OVERDUE.getMessage());
            map.put("url","/iot/admin/login");
            return new ModelAndView("common/error",map);
        }

        //校验成功,保存账号密码以及授权码

        UserInfo userInfo=new UserInfo();
        userInfo.setUserName(form.getUserName());
        userInfo.setUserPassWord(form.getPassWord());
        userInfo.setUserSerialNumber(form.getSerialNumber());
        companyInfo.setIsOverdue(1);
        try {
            userInfoService.save(userInfo);
            //失效授权码
            companyInfoService.save(companyInfo);
        }
        catch (Exception e){
            map.put("msg",e.getMessage());
            map.put("url","/iot/admin/login");
            return new ModelAndView("common/error",map);
        }




        map.put("msg",ResultEnum.REGISTER_SUCCESS.getMessage());
        map.put("url","/iot/admin/login");
        return new ModelAndView("common/successreg",map);

    }

    @GetMapping(value = "/logout")
    public ModelAndView logout(HttpServletResponse response,
                               HttpServletRequest request,
                               Map<String,Object> map){
        //查询cookie
        Cookie cookie=CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie!=null){
            //清除redis
            //   stringRedisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            //清除cookie
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
       // map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        return new ModelAndView("redirect:/admin/login");
    }


}
