package com.tencent.wxcloudrun.request;

import lombok.Data;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 16:58
 */
@Data
public class LoginRequest {
    private String userName;
    private String userPassword;
}
