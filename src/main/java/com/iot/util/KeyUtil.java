package com.iot.util;

import java.util.Random;

public class KeyUtil {


    /*生成用户序列号ID，六位随机数*.*/
    public static synchronized String getUniqueKey(){
        Random random=new Random();
        Integer number=random.nextInt(900000)+100000;
        return String.valueOf(number);
    }
}
