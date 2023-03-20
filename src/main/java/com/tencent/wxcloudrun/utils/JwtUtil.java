package com.tencent.wxcloudrun.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 解你忧
 * @PRODUCT_NAME: IntelliJ IDEA
 * @PROJECT_NAME: WX-ChrisLin
 * @Date_Time: 2023/3/20 20:07
 */
public class JwtUtil {
    /**
     * 过期时间
     */
    private static final long EXPIRE_TIME=15*60*1000;
    /**
     * token密钥
     */
    private static final String TOKEN_SECRET="ChrisLin";
    /**
     * 签名方法
     */
    public static String sign(String userName){
        //过期时间
        Date date=new Date(System.currentTimeMillis()+EXPIRE_TIME);
        //密钥和教秘算法
        Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
        //headers
        Map<String,Object> headers = new HashMap<>(2);
        headers.put("typ","JWT");
        headers.put("alg","HS256");
        return JWT.create()
                .withHeader(headers)
                .withClaim("userName",userName)
                .withExpiresAt(date)
                .sign(algorithm);
    }
    /**
     * token校验方法
     */
    public static boolean verify(String token){
        Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier=JWT.require(algorithm).build();
        verifier.verify(token);
        return true;

    }
}
