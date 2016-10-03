package com.bbt.dao;

import com.bbt.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yuan on 10/2/16.
 */
public interface UserDao {

    /**
     * 插入新的用户
     * @param user
     */
    void addUser(User user);

    /**
     * 获取给定手机号码的用户数量
     * @param phone 手机号码
     * @return
     */
    int selectUserCountByPhone(@Param("phone") String phone);
}
