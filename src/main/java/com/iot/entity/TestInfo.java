package com.iot.entity;


import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
public class TestInfo {

    private String userName;

    private String userSerialNumber;

    private String info;

    private Date createTime;

    private Date updateTime;
}
