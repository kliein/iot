package com.iot.controller;


import com.iot.constant.User;
import com.iot.entity.TestData;
import com.iot.service.TestDataInfoService;
import com.iot.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RequestMapping(value = "/test")
@Controller
@Slf4j
public class IotTestDataController {

    @Autowired
    private TestDataInfoService testDataInfoService;


    @GetMapping(value = "/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){

        PageRequest pageRequest=new PageRequest(page-1,size);
        String userSerialNumber=CookieUtil.getCookie();
        Page<TestData> testDataPage=testDataInfoService.findAllByUserSerialNumberInOrderByCreateTimeDesc(pageRequest,userSerialNumber);
        map.put("testDataPage",testDataPage);
        map.put("currentPage",page);
        map.put("size",size);
        map.put("userName",User.userName);
        map.put("serialNumber",User.serialNumber);

        return new ModelAndView("main/index",map);

    }


    @GetMapping(value = "/explain")
    public ModelAndView explain(Map<String,Object> map){

        map.put("userName",User.userName);
        map.put("serialNumber",User.serialNumber);

        return new ModelAndView("main/explain",map);
    }
}
