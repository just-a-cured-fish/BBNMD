package com.yc.bbnmd.dao.impl;

import com.yc.bbnmd.dao.MisBaseMapper;
import com.yc.bbnmd.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper  //具体操作user表的mapper
public interface UserMapper extends MisBaseMapper<User> {
}


