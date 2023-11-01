package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.micrometer.common.util.StringUtils;
import org.example.common.ResponseStatusEnum;
import org.example.exception.CustomException;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.MD5Util;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public Result register(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        validate(user.getUsername(), user.getPassword(), user.getName());
        queryWrapper.eq("username",user.getUsername());
        boolean isExist = userMapper.exists(queryWrapper);
        if(isExist){
            return Result.error(ResponseStatusEnum.USER_ACCOUNT_EXISTED);
        }
        user.setPassword(MD5Util.encrypt(user.getPassword()));
        int rows = userMapper.insert(user);
        if(rows > 0){
            return Result.success();
        }
        return Result.error(ResponseStatusEnum.ERROR);
    }

    @Override
    public Result login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        validate(username, password);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username).eq("password",MD5Util.encrypt(password));
        User res = userMapper.selectOne(queryWrapper);
        if(res != null){
            res.setPassword(null);
            return Result.success(res);
        }
        return Result.error(ResponseStatusEnum.USERNAME_PASSWORD_ERROR);
    }

    public void validate(String username, String password) {
        if (StringUtils.isEmpty(username)) {
            // 用户名为空
            throw new CustomException(ResponseStatusEnum.USERNAME_EMPTY);
        }
        if (StringUtils.isEmpty(password)) {
            // 密码为空
            throw new CustomException(ResponseStatusEnum.PASSWORD_EMPTY);
        }
    }

    /**
     * 非空校验校验用户名、密码、昵称
     * @param username 用户名
     * @param password 密码
     * @param name 用户昵称
     */
    public void validate(String username, String password, String name) {
        validate(username, password);
        if (StringUtils.isEmpty(name)) {
            throw new CustomException(ResponseStatusEnum.NAME_EMPTY);
        }
    }
}
