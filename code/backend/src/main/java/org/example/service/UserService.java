package org.example.service;

import org.example.pojo.User;
import org.example.utils.Result;

public interface UserService {
    public Result regist(User user);
    public Result login(String username, String password);
}
