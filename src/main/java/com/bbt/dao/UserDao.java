package com.bbt.dao;

import com.bbt.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yuan on 10/2/16.
 */
public interface UserDao {
    /**
     * 获取给定用户名的用户数量
     * @param userName
     * @return
     */
    int selectUserCountByUserName(@Param("userName") String userName);

    /**
     * 插入新的用户
     * @param user
     */
    void addUser(User user);
}
