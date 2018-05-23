package com.ray.service;

import com.ray.entity.User;

/**
 * @author Ray
 * @date 2018/5/23 0023
 */
public interface UserService {

    void save(User user);
    User checkLogin(String userName, String userPwd);
    boolean checkRegister(String userName, String userPwd, String email);
    boolean updatePwd(String newPwd, String username);
}
