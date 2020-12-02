package com.yc.bbnmd.service;

import com.yc.bbnmd.dao.impl.UserMapper;
import com.yc.bbnmd.entity.User;
import com.yc.bbnmd.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        User userBean = new User();
        userBean.setUname(user.getUname());
        userBean.setRole("普通用户");
        try {
            userBean.setUpwd(CommonUtils.EncoderByMd5(user.getUpwd()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.userMapper.insert(userBean);
        // 在这里  mybatis完成了两步操作: 1. insert   2. select 到最新的id后，存到user中
        //user中的id已经获取到
        //关键:
        user.setUid(userBean.getUid());
    }

    @Override
    public void delete(Integer id) {
        this.userMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findOne(Integer id) {
        User user = this.userMapper.selectByPrimaryKey(id);
        User userbean = new User(user.getUid(), user.getUname(),user.getRole());
        return userbean;
    }


}
