package org.example.service;

import org.example.pojo.User;
import org.example.pojo.UserPassword;
import org.example.utils.Result;

/**
 * @author yt
 */
public interface UserService {
    /**
     * 更新用户的信息
     * @param user 用户实体
     * @return 响应结果
     */
    Result update(User user);

    /**
     * 用户注册
     * @param user 用户实体
     * @return 响应对象
     */
    Result register(User user);

    /**
     * 用户登录服务
     * @param user 用户实体
     * @return 响应结果
     */
    Result login(User user);

    /**
     * 修改用户密码服务
     * @param userPassword 用户密码实体 包含旧密码和新密码
     * @return
     */
    Result rPassword(UserPassword userPassword);

    /**
     * 根据用户的ID查询用户的所有信息
     * @param userId 用户ID
     * @return 用户信息
     */
    User getUserById(Integer userId);
}
