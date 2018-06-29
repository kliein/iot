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
public class CompanyInfo {

    @Id
    @GeneratedValue
    private Integer registerId;

    private String registerName;
    private String serialNumber;
    private Integer isOverdue;//KEY是否过期
    private  Date createTime;

    private Date updateTime;


    @Override
    public String toString() {
        return "CompanyInfo{" +
                "registerId=" + registerId +
                ", registerName='" + registerName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
