package com.iot.Respository;

import com.iot.entity.CompanyInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CompanyInfoRespositoryTest {

    @Autowired
    private CompanyInfoRespository companyInfoRespository;

    @Test
    public void findOneTest(){
        CompanyInfo companyInfo=companyInfoRespository.findOne(1);
        System.out.println(companyInfo.toString());
        Assert.assertNotNull(companyInfo);
    }

    @Test
    public void saveTest(){
        CompanyInfo companyInfo=new CompanyInfo();
        companyInfo.setRegisterName("LCWLW");
        companyInfo.setSerialNumber("LC146568631");
        companyInfoRespository.save(companyInfo);

    }

    @Test
    public void findBySerialNumberIn(){
        CompanyInfo companyInfo=companyInfoRespository.findBySerialNumberIn("LC123456");
        log.info("【查询结果】{}",companyInfo.toString());
    }
}