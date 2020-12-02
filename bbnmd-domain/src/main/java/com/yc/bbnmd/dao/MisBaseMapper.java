package com.yc.bbnmd.dao;


import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.MySqlMapper;

//通用的操作接口    :   这个通用操作接口必须在不同的包(与其它的Mapper不在一起)
public interface MisBaseMapper<T> extends BaseMapper<T>, ExampleMapper<T>, MySqlMapper {
}

