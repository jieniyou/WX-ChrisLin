package com.tencent.wxcloudrun.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/25 23:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String userName;
    private String userNickName;
    private String userAvatar;
    private String userEmail;
    private String userPhone;
}
