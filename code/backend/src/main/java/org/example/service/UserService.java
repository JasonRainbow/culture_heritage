package org.example.service;

import org.example.pojo.User;
import org.example.pojo.UserPassword;
import org.example.utils.Result;

public interface UserService {
    public Result update(User user);

    public Result register(User user);

    public Result login(User user);

    Result rPassword(UserPassword userPassword);

    /**
     * 根据用户的ID查询用户的所有信息
     * @param userId 用户ID
     * @return 用户信息
     */
    User getUserById(Integer userId);
}
