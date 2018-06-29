package com.iot.service;

import com.iot.entity.TestData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface TestDataInfoService {

    Page<TestData> findAllByUserSerialNumberAndSlaveNumberOrderByCreateTimeDesc(Pageable pageable, String userSerialNumber,Integer slaveNumber);

    Page<TestData> findAllByUserSerialNumberInOrderByCreateTimeDesc(Pageable pageable,String userSerialNumber);

    TestData save(TestData testData);
}
