package com.bbt.service.impl;

import com.bbt.dao.UserDao;
import com.bbt.model.Result;
import com.bbt.model.User;
import com.bbt.service.UserService;
import com.yuan.validation.ValidInfo;
import com.yuan.validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yuan on 10/2/16.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserDao userDao;

    /**
     * 注册新用户
     * @param user
     * @return
     */
    public Result register(User user) {
        Result result=new Result();
        if(!checkUser(user)){
            result.setStatusFail();
        }else{
            userDao.addUser(user);
            result.setStatusOk();
        }
        return result;
    }


    /**
     * 检查注册的新用户的信息是否符合规范(例如用户名是否唯一,密码是否符合规矩)
     * @param user
     * @return
     */
    private boolean checkUser(User user) {
        ValidInfo validInfo= Validation.validatePattern(user);
        if(validInfo.hasError())
            return false;
        String userName=user.getUserName();
        int count=userDao.selectUserCountByUserName(userName);
        if(count>0)
            return false;
        return true;
    }
}
