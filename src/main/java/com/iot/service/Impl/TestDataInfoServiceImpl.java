package com.iot.service.Impl;

import com.iot.Respository.TestDataInfoRespository;
import com.iot.entity.TestData;
import com.iot.service.TestDataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TestDataInfoServiceImpl implements TestDataInfoService {

    @Autowired
    private TestDataInfoRespository testDataInfoRespository;

    @Override
    public Page<TestData> findAllByUserSerialNumberAndSlaveNumberOrderByCreateTimeDesc(Pageable pageable, String userSerialNumber, Integer slaveNumber) {
        return testDataInfoRespository.findAllByUserSerialNumberAndSlaveNumberOrderByCreateTimeDesc(pageable,userSerialNumber,slaveNumber);
    }

    @Override
    public Page<TestData> findAllByUserSerialNumberInOrderByCreateTimeDesc(Pageable pageable, String userSerialNumber) {
        return testDataInfoRespository.findAllByUserSerialNumberInOrderByCreateTimeDesc(pageable,userSerialNumber);
    }

    @Override
    public TestData save(TestData testData) {
        return testDataInfoRespository.save(testData);
    }
}
