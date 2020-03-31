package com.xk.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtUtil {

    /**
     * 特别注意失效时间要设置再后边
     * 否则会被 .setClaims(map) 方法覆盖，导致失效时间无效
     *
     * @param user
     * @return
     */
    public String getToken(JwtUser user) {
        String token = "";
        token = JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
