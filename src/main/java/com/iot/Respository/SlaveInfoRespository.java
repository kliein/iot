package com.iot.Respository;

import com.iot.entity.SlaveInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlaveInfoRespository extends JpaRepository<SlaveInfo,Integer> {

    SlaveInfo findByUserSerialNumberIn(String userSerialNumber);

    Page<SlaveInfo> findAllByUserSerialNumberInOrderByCreateTimeDesc(Pageable pageable,String userSerialNumber);

    SlaveInfo findBySlaveNumberIn(Integer slaveNumber);

    int deleteByUserSerialNumberAndSlaveNumberIn(String userSerialNumber,Integer slaveNumber);

}
