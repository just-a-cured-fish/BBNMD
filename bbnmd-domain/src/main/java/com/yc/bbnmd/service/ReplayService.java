package com.yc.bbnmd.service;

import com.yc.bbnmd.entity.Replay;
import com.yc.bbnmd.entity.Topic;

public interface ReplayService {
    /**
     * 回复帖子
     *
     * @param replay
     */
    public void save(Replay replay);

    /**
     * 删除帖子
     *
     * @param id
     */
    public void delete(Integer id);

    /**
     * 根据id查帖子信息
     *
     * @param id
     * @return
     */
    public Replay findOne(Integer id);
}
