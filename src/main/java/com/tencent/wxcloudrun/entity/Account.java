package com.tencent.wxcloudrun.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 16:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String userName;
    private String userPassword;
    private String userNickName;
    private String userEmail;
    private String userPhone;
}
