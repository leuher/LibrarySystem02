package com.ray.service.impl;

import com.ray.dao.UserMapper;
import com.ray.entity.User;
import com.ray.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Ray
 * @date 2018/5/23 0023
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 新增用户
     * @param user
     */
    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    /**
     * 登录检查
     * @param userName
     * @param userPwd
     * @return
     */
    @Override
    public User checkLogin(String userName, String userPwd) {
        User user = userMapper.selectUser(userName);
        if(user != null && user.getUserPwd().equals(userPwd)){
            return user;
        }
        return null;
    }

    /**
     * 注册检查
     * @param userName
     * @param userPwd
     * @param email
     * @return
     */
    @Override
    public boolean checkRegister(String userName, String userPwd, String email) {
        User user = userMapper.selectUser(userName);
        if(user != null){
            return false;
        }else{
            User insertUser = new User();
            insertUser.setUserName(userName);
            insertUser.setUserPwd(userPwd);
            insertUser.setUserEmail(email);
            save(insertUser);
            return true;
        }
    }

    /**
     * 更改密码
     * @param newPwd
     * @param username
     * @return
     */
    @Override
    public boolean updatePwd(String newPwd, String username) {
        userMapper.updatePwd(newPwd, username);
        return true;
    }
}
