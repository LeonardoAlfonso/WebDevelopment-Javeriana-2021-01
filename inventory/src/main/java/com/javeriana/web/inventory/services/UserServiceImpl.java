package com.javeriana.web.inventory.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final String SECRET = "web_inventory";
    private final String ID = "inventoryAppToken";
    private final String CLAIM = "authorities";
    private final int validity = 60000;
    private final String PREFIX = "Bearer ";

    @Override
    public String getToken(String username) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.
                commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts.builder()
                .setId(ID)
                .setSubject(username)
                .claim(CLAIM, grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
        return PREFIX + token;
    }
}
