package com.iot.service.Impl;

import com.iot.Respository.CompanyInfoRespository;
import com.iot.entity.CompanyInfo;
import com.iot.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    private CompanyInfoRespository companyInfoRespository;

    @Override
    public CompanyInfo findBySerialNumberIn(String serialNumber) {
        return companyInfoRespository.findBySerialNumberIn(serialNumber);
    }

    @Override
    public CompanyInfo save(CompanyInfo companyInfo) {
        return companyInfoRespository.save(companyInfo);
    }
}
