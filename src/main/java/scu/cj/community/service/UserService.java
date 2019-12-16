package scu.cj.community.service;

import scu.cj.community.exception.CustomizeErrorCode;
import scu.cj.community.exception.CustomizeException;
import scu.cj.community.mapper.UserMapper;
import scu.cj.community.model.User;
import scu.cj.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            // 插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        } else {
            //更新
            User dbUser = users.get(0);
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            UserExample example = new UserExample();
            example.createCriteria()
                    .andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser, example);
        }
    }

    public User validationUser(String studentId,String password){
        User user = userMapper.validationUser(studentId, password);

        return  user;

    }

    public boolean insertNewUser(User user){

           return  userMapper.insertNewUser(user);
    }

    public boolean findIfStudentIdExits(String studentId){
        User user = userMapper.findIfStudentIdExits(studentId);
        if (user==null){
            return true;
        }
        else{
            return  false;
        }

    }

    public List<User> findAllUser(){
        List<User> users = userMapper.findAllUser();
        for(User user : users){
                user.setPassword(MD5Utils.stringToMD5(user.getPassword()));
        }
        return  users;
    }
}
