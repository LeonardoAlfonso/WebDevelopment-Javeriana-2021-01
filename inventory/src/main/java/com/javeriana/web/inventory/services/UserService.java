package com.javeriana.web.inventory.services;

import com.javeriana.web.inventory.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public String getToken(String username) throws Exception;
    public User addUser(User user) throws Exception;
    public void updateUser(User user) throws Exception;
    public void getUser(long idUser) throws Exception;
    public List<User> getAllUsers() throws Exception;
    public void deleteUser(User user) throws Exception;
    public boolean authentication(String username, String password) throws Exception;

}
