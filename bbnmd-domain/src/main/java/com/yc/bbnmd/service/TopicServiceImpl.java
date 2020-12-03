package com.yc.bbnmd.service;

import com.yc.bbnmd.dao.impl.TopicMapper;
import com.yc.bbnmd.entity.Topic;
import com.yc.bbnmd.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired(required = false)
    private TopicMapper topicMapper;

    @Override
    public void save(Topic topic) {
        Topic topicBean = new Topic();
        topicBean.setContent(topic.getContent());
        topicBean.setUid(topic.getUid());
        topicBean.setTime(CommonUtils.formatDateTime(new Date()));
        this.topicMapper.insert(topicBean);

        topic.setTid(topicBean.getTid());
    }

    @Override
    public void delete(Integer id) {
        this.topicMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Topic findOne(Integer id) {
        Topic topic = this.topicMapper.selectByPrimaryKey(id);
        System.out.println("\nTopic findOne:");
        System.out.println(topic);
        return topic;
    }


}
