package com.iot.service;

import com.iot.entity.UserInfo;

public interface UserInfoService {
    UserInfo save(UserInfo userInfo);

    UserInfo findOne(Integer userId);

    UserInfo findByUserNameIn(String userName);

}
