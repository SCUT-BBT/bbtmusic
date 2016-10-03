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

    public Result register(User user) {
        Result result=new Result();
        int code=checkUser(user);
        if(code>0){
            result.setCode(code);
            return result;
        }
        userDao.addUser(user);
        result.addData("userId",user.getId());
        result.setCode(0);
        return result;
    }

    public Result login(User user) {
        Result result=new Result();
        ValidInfo validInfo=Validation.validatePattern(user);
        if(validInfo.hasError()){
            result.setCode(1);
            return result;
        }
        Integer userId=userDao.selectUser(user);
        if(userId==null){
            result.setCode(1);
            return result;
        }
        result.addData("userId",userId);
        result.setCode(0);
        return result;
    }


    /**
     * 检查注册的新用户的信息是否符合规范(例如用户名是否唯一,密码是否符合规矩)
     * @param user
     * @return
     */
    private int checkUser(User user) {
        ValidInfo validInfo= Validation.validatePattern(user);
        if(validInfo.hasError())
            return 2;
        String phone=user.getPhone();
        int count=userDao.selectUserCountByPhone(phone);
        if(count>0)
            return 1;
        return 0;
    }


}
