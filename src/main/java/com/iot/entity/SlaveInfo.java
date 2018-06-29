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
public class SlaveInfo {

    @Id
    @GeneratedValue
    private int slaveId;
    private String userSerialNumber;
    private int slaveNumber;
    private String slaveIp;
    private String slaveRemark;

    private Date createTime;
    private Date updateTime;
}
