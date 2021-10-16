package com.pricemonitor.pm_backend.util;

import io.jsonwebtoken.Jwts;

/**
 * @author yzd
 */
public class JwtUtil {

    /**
     * 从token中取出用户id，若token为空则返回id:0
     * @param token
     * @return
     */
    public static int getUserId(String token) {
        String userId;
        if (token != null) {
            // 若存在token，解析token
            userId = Jwts.parser()
                    .setSigningKey("Rude3KnifeJwtSecret")
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getId();
            return Integer.parseInt(userId);
        }
        return 0;
    }
}
