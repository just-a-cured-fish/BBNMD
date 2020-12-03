package com.yc.bbnmd.dao.impl;

import com.yc.bbnmd.dao.MisBaseMapper;
import com.yc.bbnmd.entity.Replay;
import com.yc.bbnmd.entity.Topic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper  //具体操作replay表的mapper
public interface ReplayMapper extends MisBaseMapper<Replay> {
}
