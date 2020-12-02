package com.yc.bbnmd.service;

import com.yc.bbnmd.entity.User;

import java.util.List;

public interface UserService {



    /**
     * 保存新图片
     *
     * @param user
     */
    public void save(User user);

    /**
     * 删除图片
     *
     * @param id
     */
    public void delete(Integer id);

    /**
     * 根据id查图片详情(    图片的metadata )
     *
     * @param id
     * @return
     */
    public User findOne(Integer id);


}
