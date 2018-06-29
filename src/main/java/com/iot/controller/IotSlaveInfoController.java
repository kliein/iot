package com.iot.controller;


import com.iot.constant.User;
import com.iot.entity.SlaveInfo;
import com.iot.enums.ResultEnum;
import com.iot.exception.IotException;
import com.iot.form.SlaveForm;
import com.iot.service.SlaveInfoService;
import com.iot.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RequestMapping(value = "/slave")
@Controller
public class IotSlaveInfoController {

    @Autowired
    private SlaveInfoService slaveInfoService;

    @GetMapping(value = "/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){


        log.info("【进入list方法】");
        PageRequest pageRequest=new PageRequest(page-1,size);
        String userSerialNumber=CookieUtil.getCookie();
        Page<SlaveInfo> slaveInfoPage=slaveInfoService.findAllByUserSerialNumberInOrderByCreateTimeDesc(pageRequest,userSerialNumber);
        map.put("slaveInfoPage",slaveInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        map.put("userName",User.userName);
        map.put("serialNumber",User.serialNumber);
        log.info("【数据条数】：{}",slaveInfoPage.getTotalElements()+userSerialNumber);
        return new ModelAndView("slave/index",map);
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@Valid SlaveForm form,
                     BindingResult bindingResult,
                     Map<String,Object> map,
                     HttpServletResponse response){

        log.info("【进入slave/save】");
        log.info("【form】:{}",form.toString());
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/iot/slave/list");
            return new ModelAndView("common/error",map);
        }
        SlaveInfo slaveInfo=new SlaveInfo();
        try {
            slaveInfo=slaveInfoService.findBySlaveNumberIn(form.getSlaveNumber());

        }
        catch (IotException e){
            map.put("msg",e.getMessage());
            map.put("url","/iot/slave/list");
            return new ModelAndView("common/error",map);
        }
        if(slaveInfo!=null){
            map.put("msg",ResultEnum.SLAVE_IS_EXIST.getMessage());
            map.put("url","/iot/slave/list");
            return new ModelAndView("common/error",map);
        }
        else {
            slaveInfo=new SlaveInfo();
        }

        BeanUtils.copyProperties(form,slaveInfo);
        slaveInfo.setUserSerialNumber(CookieUtil.getCookie());
        slaveInfo.setSlaveIp("0.0.0.0");
        log.info("【slaveinfo】:{}",slaveInfo.toString());
        try {
            slaveInfoService.save(slaveInfo);
        }
        catch (IotException e){
            map.put("msg",e.getMessage());
            map.put("url","/iot/slave/list");
            return new ModelAndView("common/error",map);
        }

        return new ModelAndView("redirect:/slave/list");



    }

    @GetMapping(value = "/delete")
    @org.springframework.transaction.annotation.Transactional
    public ModelAndView delete(@RequestParam("slaveNumber") Integer slaveNumber,
                               Map<String,Object> map){
        log.info("【设备编号】：{}",slaveNumber);
        String userSerialNumber=CookieUtil.getCookie();
        if(slaveNumber==null){
            map.put("msg",ResultEnum.SLAVE_NUMBER_ERROR.getMessage());
            map.put("url","/iot/slave/list");
            return new ModelAndView("common/error",map);
        }

        SlaveInfo slaveInfo=new SlaveInfo();
        try {
            slaveInfo=slaveInfoService.findBySlaveNumberIn(slaveNumber);
        }
        catch (IotException e){
            map.put("msg",e.getMessage());
            map.put("url","/iot/slave/list");
            return new ModelAndView("common/error",map);
        }

        if(slaveInfo==null){
            map.put("msg",ResultEnum.SLAVE_NOT_EXIST.getMessage());
            map.put("url","/iot/slave/list");
            return new ModelAndView("common/error",map);
        }
        try{
            slaveInfoService.deleteByUserSerialNumberAndSlaveNumberIn(userSerialNumber,slaveNumber);
        }
        catch (IotException e){
            map.put("msg",e.getMessage());
            map.put("url","/iot/slave/list");
            return new ModelAndView("common/error",map);
        }
        return new ModelAndView("redirect:/slave/list");

    }


}
