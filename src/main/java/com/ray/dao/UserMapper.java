package com.ray.dao;

import com.ray.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUser(@Param("userName") String userName);

    void updatePwd(@Param("userPwd") String newPwd,
                   @Param("userName") String userName);
}