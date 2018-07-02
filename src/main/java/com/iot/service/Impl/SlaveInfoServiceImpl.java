package com.iot.service.Impl;

import com.iot.Respository.SlaveInfoRespository;
import com.iot.entity.SlaveInfo;
import com.iot.service.SlaveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SlaveInfoServiceImpl implements SlaveInfoService {

    @Autowired
    private SlaveInfoRespository slaveInfoRespository;

    @Override
    public SlaveInfo save(SlaveInfo slaveInfo) {
        return slaveInfoRespository.save(slaveInfo);
    }

    @Override
    public SlaveInfo findByUserSerialNumberIn(String userSerialNumber) {
        return slaveInfoRespository.findByUserSerialNumberIn(userSerialNumber);
    }

    @Override
    public Page<SlaveInfo> findAllByUserSerialNumberInOrderByCreateTimeDesc(Pageable pageable, String userSerialNumber) {
        return slaveInfoRespository.findAllByUserSerialNumberInOrderByCreateTimeDesc(pageable,userSerialNumber);
    }

    @Override
    public SlaveInfo findBySlaveNumberIn(Integer slaveNumber) {
        return slaveInfoRespository.findBySlaveNumberIn(slaveNumber);
    }

    @Override
    public int deleteByUserSerialNumberAndSlaveNumberIn(String userSerialNumber, Integer slaveNumber) {
        return slaveInfoRespository.deleteByUserSerialNumberAndSlaveNumberIn(userSerialNumber,slaveNumber);
    }

    @Override
    public SlaveInfo findByUserSerialNumberAndSlaveNumberIn(String userSerialNumber, Integer slaveNumber) {
        return slaveInfoRespository.findByUserSerialNumberAndSlaveNumberIn(userSerialNumber,slaveNumber);
    }
}
