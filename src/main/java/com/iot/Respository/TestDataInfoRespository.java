package com.iot.Respository;

import com.iot.entity.TestData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TestDataInfoRespository extends JpaRepository<TestData,Integer> {

    Page<TestData> findAllByUserSerialNumberAndSlaveNumberOrderByCreateTimeDesc(Pageable pageable, String userSerialNumber,Integer slaveNumber);

    Page<TestData> findAllByUserSerialNumberInOrderByCreateTimeDesc(Pageable pageable, String userSerialNumber);

}
