package com.iot.service;


import com.iot.entity.SlaveInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SlaveInfoService {
    SlaveInfo save(SlaveInfo slaveInfo);
    SlaveInfo findByUserSerialNumberIn(String userSerialNumber);
    Page<SlaveInfo> findAllByUserSerialNumberInOrderByCreateTimeDesc(Pageable pageable,String userSerialNumber);
    SlaveInfo findBySlaveNumberIn(Integer slaveNumber);
    SlaveInfo findByUserSerialNumberAndSlaveNumberIn(String userSerialNumber,Integer slaveNumber);
    int deleteByUserSerialNumberAndSlaveNumberIn(String userSerialNumber,Integer slaveNumber);
}
