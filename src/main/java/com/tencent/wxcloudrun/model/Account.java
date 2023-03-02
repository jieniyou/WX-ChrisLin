package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-springboot-demo01
 * @Date_Time: 2023/3/2 15:45
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private String account;
    private String netName;
    private String password;
    private String email;
    private String phoneNumber;

}
