package com.bbt.service;

import com.bbt.model.Result;
import com.bbt.model.User;

/**
 * Created by yuan on 10/2/16.
 */
public interface UserService {
    /**
     * 注册用户服务
     * @param user
     * @return
     */
    Result register(User user);

    /**
     * 用户登陆服务
     * @param user
     * @return
     */
    Result login(User user);
}
