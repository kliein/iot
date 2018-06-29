package com.iot.service.Impl;

import com.iot.Respository.UserInfoRespository;
import com.iot.entity.UserInfo;
import com.iot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRespository userInfoRespository;
    @Override
    public UserInfo save(UserInfo userInfo) {
        userInfoRespository.save(userInfo);
        return userInfo;
    }

    @Override
    public UserInfo findOne(Integer userId) {
        return userInfoRespository.findOne(userId);
    }

    @Override
    public UserInfo findByUserNameIn(String userName) {
        return userInfoRespository.findByUserNameIn(userName);
    }
}

