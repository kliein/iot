package com.iot.controller;


import com.iot.entity.CompanyInfo;
import com.iot.exception.IotException;
import com.iot.service.CompanyInfoService;
import com.iot.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/company")
@Slf4j
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;


    @GetMapping(value = "/authorize")
    public String authorize(@RequestParam("name") String companyName){

        if(companyName==null){
            return  "wrong param";
        }

        if(!companyName.equals("langchuang")){
            return "wrong param";
        }

        CompanyInfo companyInfo=new CompanyInfo();
        String key=KeyUtil.getUniqueKey();
        companyInfo.setSerialNumber(key);
        companyInfo.setIsOverdue(0);
        try {
            companyInfoService.save(companyInfo);
        }
        catch (IotException e){
            return e.getMessage();
        }

        return key;
    }

}
