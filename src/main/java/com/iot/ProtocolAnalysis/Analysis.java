package com.iot.ProtocolAnalysis;


//协议解析../
public class Analysis {

    private final int FIXED_LENGTH=11;

    //返回数据包
    public String analysisData(int[] data){
        String upData="";
        if((data[0]!=0x55)||(data[1]!=0xaa)){
            return null;
        }
        int dataLength=dataLength(data);
        int length=dataLength+FIXED_LENGTH;
        if((data[length-1])!=(check(data))){
            return null;
        }

        for(int i=0;i<dataLength;i++){
            upData+=Long.toHexString(data[10+i]).toUpperCase()+",";
        }
        return upData;
    }



    // 55 AA    用户序列号   设备ID       数据长度  数据      校验
    // 55 AA    55 55 55    55 55 55     55 55   11 11      21
    // 2字节      3字节      3字节         2字节    2字节    和校验（从序列号开始到数据位最后一位）


    //获取用户序列号
    public String analysisSerialNumber(int[] data){
        String s=Long.toHexString(data[2]).toUpperCase()+Long.toHexString(data[3]).toUpperCase()+Long.toHexString(data[4]).toUpperCase();
        int length=Integer.parseInt(s,16);
        return String.valueOf(length);
    }


    //获取设备ID
    public int analysisSlaveNumber(int[] data){
        String s=Long.toHexString(data[5]).toUpperCase()+Long.toHexString(data[6]).toUpperCase()+Long.toHexString(data[7]).toUpperCase();
        return Integer.parseInt(s,16);
    }

    private int check(int[] data){
        int checkSun=0;
        for(int i=0;i<data.length-1;i++){
            checkSun+=data[i];
        }
        checkSun=checkSun&0xff;
        return checkSun;
    }

    //获取数据长度
    private int dataLength(int[] data){

        String s=Long.toHexString(data[8]).toUpperCase()+Long.toHexString(data[9]).toUpperCase();
        int length=Integer.parseInt(s,16);
//        Integer.parseInt(String s, int radix)
//        String str = Long.toHexString(421393700).toUpperCase();
        return length;
    }
}
