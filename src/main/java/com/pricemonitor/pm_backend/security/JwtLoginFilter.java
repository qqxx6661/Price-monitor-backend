package com.pricemonitor.pm_backend.security;

import com.pricemonitor.pm_backend.bean.action.MyUserDetails;
import io.jsonwebtoken.Jwts;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pricemonitor.pm_backend.bean.pojo.User;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author yzd
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 接收并解析用户凭证
     * @param req
     * @param res
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            User user = new ObjectMapper().readValue(req.getInputStream(), User.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
     * @param req
     * @param res
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        MyUserDetails myUserDetails = (MyUserDetails) auth.getPrincipal();
        String token = Jwts.builder()
                .setSubject(myUserDetails.getUsername())
                .setId(String.valueOf(myUserDetails.getId()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .signWith(SignatureAlgorithm.HS512, "Rude3KnifeJwtSecret")
                .compact();
        // 加入token
        res.addHeader("Authorization", "Bearer " + token);
        // 加入用户昵称，注意是getName而非getUserName，getUserName返回的登录名是邮箱
        // header无法直接传输中文，需要后台encode前台decode
        res.addHeader("Nickname", URLEncoder.encode(String.valueOf(myUserDetails.getName()), "UTF-8"));
        // 解决无法获取Authorization问题，https://www.jianshu.com/p/756bdac84869, https://www.jianshu.com/p/8612ef7b8543
        res.addHeader("Access-Control-Expose-Headers", "Authorization, Nickname");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Origin", "*");
    }
}