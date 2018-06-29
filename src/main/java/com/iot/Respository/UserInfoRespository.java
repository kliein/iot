package com.iot.Respository;


import com.iot.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRespository extends JpaRepository<UserInfo,Integer> {
    UserInfo findByUserNameIn(String userName);
}
