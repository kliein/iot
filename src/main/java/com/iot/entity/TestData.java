package com.iot.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class TestData {

    @Id
    @GeneratedValue
    private int testDataId;

    private String userSerialNumber;
    private int slaveNumber;
    private String slaveIp;
    private String testDataInfo;
    private String type;
    private Date createTime;
    private Date updateTime;

}
