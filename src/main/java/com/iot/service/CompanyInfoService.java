package com.iot.service;

import com.iot.entity.CompanyInfo;

public interface CompanyInfoService {

    CompanyInfo findBySerialNumberIn(String serialNumber);
    CompanyInfo save(CompanyInfo companyInfo);
}
