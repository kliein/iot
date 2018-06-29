package com.iot.Respository;

import com.iot.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyInfoRespository extends JpaRepository<CompanyInfo,Integer> {

    CompanyInfo findBySerialNumberIn(String serialNumber);

}
