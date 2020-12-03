package com.yc.bbnmd.service;

import com.yc.bbnmd.entity.User;

import java.util.List;

public interface UserService {



    /**
     * 用户注册
     *
     * @param user
     */
    public void save(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    public void delete(Integer id);

    /**
     * 根据id查用户信息
     *
     * @param id
     * @return
     */
    public User findOne(Integer id);


}
