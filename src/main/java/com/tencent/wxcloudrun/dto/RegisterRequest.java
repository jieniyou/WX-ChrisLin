package com.tencent.wxcloudrun.dto;

import lombok.Data;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/2 20:34
 */
@Data
public class RegisterRequest {
    private String account;
    private String netName;
    private String password;
    private String email;
    private String phoneNumber;
}
