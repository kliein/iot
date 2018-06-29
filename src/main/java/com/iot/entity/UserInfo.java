package com.iot.entity;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class UserInfo {

    @Id
    @GeneratedValue
    private Integer userId;
    private String userName;
    private String userPassWord;
    private String userSerialNumber;
    private Date createTime;
    private Date updateTime;


}
