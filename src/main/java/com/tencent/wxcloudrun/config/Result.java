package com.tencent.wxcloudrun.config;

import lombok.Data;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 17:09
 */
@Data
public class Result extends CodeAndMessage{
    private Integer status;
    private String msg;
    private Object data;

    public Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public static Result success(){
        return new Result(SUCCESS_CODE,SUCCESS_MESSAGE,null);
    }
    public static Result success(Object data){
        return new Result(SUCCESS_CODE,SUCCESS_MESSAGE,data);
    }
    public static Result success(String msg,Object data){
        return new Result(SUCCESS_CODE,msg,data);
    }
    public static Result success(Integer status, String msg,Object data){
        return new Result(status,msg,data);
    }

    public static Result fail(){
        return new Result(FAIL_CODE,FAIL_MESSAGE,null);
    }
    public static Result fail(Object data){
        return new Result(FAIL_CODE,FAIL_MESSAGE,data);
    }
    public static Result fail(String msg,Object data){
        return new Result(FAIL_CODE,msg,data);
    }
    public static Result fail(Integer status, String msg,Object data){
        return new Result(status,msg,data);
    }
}
