package com.yc.bbnmd.service;

import com.yc.bbnmd.dao.impl.ReplayMapper;

import com.yc.bbnmd.entity.Replay;
import com.yc.bbnmd.entity.Topic;

import com.yc.bbnmd.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class ReplayServiceImpl implements ReplayService {

    @Autowired(required = false)
    private ReplayMapper replayMapper;

    @Override
    public void save(Replay replay) {
        Replay repalyBean = new Replay();
        repalyBean.setContent(replay.getContent());
        repalyBean.setTid(replay.getTid());
        repalyBean.setTime(CommonUtils.formatDateTime(new Date()));
        this.replayMapper.insert(repalyBean);

        replay.setRid(repalyBean.getRid());
    }

    @Override
    public void delete(Integer id) {
        this.replayMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Replay findOne(Integer id) {
        Replay replay = this.replayMapper.selectByPrimaryKey(id);
        System.out.println("\nReplay findOne:");
        System.out.println(replay);
        return replay;
    }


}
