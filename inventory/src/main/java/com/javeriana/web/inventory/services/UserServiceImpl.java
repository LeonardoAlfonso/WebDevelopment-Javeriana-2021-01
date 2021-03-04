package com.javeriana.web.inventory.services;

import com.javeriana.web.inventory.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.javeriana.web.inventory.InventoryApplication.LOGGER;

@Service
public class UserServiceImpl implements UserService {

    private final String SECRET = "web_inventory";
    private final String ID = "inventoryAppToken";
    private final String CLAIM = "authorities";
    private final int validity = 60000;
    private final String PREFIX = "Bearer ";
    private final int STRENGTH = 12;
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getToken(String username) throws Exception {
        try {
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
        catch(Exception e) {
            LOGGER.error("UserServiceImpl.getToken Causa: " + e.toString());
            throw new Exception("UserServiceImpl.getToken Causa: " + e.toString());
        }
    }

    @Override
    public User addUser(User user) throws Exception {
        try {
            if(this.validateUserName(user.getUsername())) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(STRENGTH);
                String encodedPassword = encoder.encode(user.getPassword());
                user.setPassword(encodedPassword);
                user.setEnabled(true);
                user = this.repository.save(user);
            }
            else {
                user = null;
            }
        }
        catch (Exception e) {
            LOGGER.error("UserServiceImpl.addUser Causa: " + e.toString());
            throw new Exception("UserServiceImpl.addUser Causa: " + e.toString());
        }
        return user;
    }

    private boolean validateUserName(String username) throws Exception {
        boolean result = true;
        try {
            User user = this.repository.getByUsername(username);
            if(user != null) {
                result = false;
            }
        }
        catch (Exception e) {
            LOGGER.error("UserServiceImpl.validateUser Causa: " + e.toString());
            throw new Exception("UserServiceImpl.validateUser Causa: " + e.toString());
        }
        return result;
    }

    @Override
    public void updateUser(User user) throws Exception {

    }

    @Override
    public void getUser(long idUser) throws Exception {

    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return null;
    }

    @Override
    public void deleteUser(User user) throws Exception {

    }

    @Override
    public boolean authentication(String username, String password) throws Exception {
        boolean result = false;
        try {
            User user = this.repository.getByUsername(username);
            if(user != null) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(STRENGTH);
                result = encoder.matches(password, user.getPassword());
            }
        }
        catch (Exception e) {
            LOGGER.error("UserServiceImpl.authentication Causa: " + e.toString());
            throw new Exception("UserServiceImpl.authentication Causa: " + e.toString());
        }
        return result;
    }
}
