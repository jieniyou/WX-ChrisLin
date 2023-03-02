package com.tencent.wxcloudrun.dto;

import lombok.Data;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-springboot-demo01
 * @Date_Time: 2023/3/2 15:54
 */
@Data
public class LoginRequest {
    private String account;
    private String password;
}
