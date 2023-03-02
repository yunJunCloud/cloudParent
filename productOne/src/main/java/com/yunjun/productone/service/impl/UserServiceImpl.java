package com.yunjun.productone.service.impl;

import com.yunjun.productone.mapper.UserMapper;
import com.yunjun.productone.model.User;
import com.yunjun.productone.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PACKAGE_NAME: com.yunjun.productone.service.impl
 * @NAME: UserServiceImpk
 * @USER: jack
 * @DATE: 2/26/2023
 * @PROJECT_NAME: cloudParent
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
