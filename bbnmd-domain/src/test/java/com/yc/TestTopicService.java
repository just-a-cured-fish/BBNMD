package com.yc;


import com.yc.bbnmd.entity.Topic;
import com.yc.bbnmd.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Random;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfiguration.class})
public class TestTopicService {

    private static final Logger logger = Logger.getLogger(TestTopicService.class.getName());

    @Autowired
    private TopicService topicService;



    @Test
    public void testFindOne() {
        Topic topic = new Topic();
        topic.setTid(1);
        logger.info("调用UserService.findOne");
        Topic topicBean = topicService.findOne(topic.getTid());
        System.out.println(topicBean);
    }

    @Test
    public void testSave() {
        Random r=new Random();
        Topic topic = new Topic();
        topic.setContent("什么时候放假？？");
        topic.setUid(1);
        topicService.save(topic);
        logger.info("新增的帖子编号:" + topic.getTid());
        //断言.
        Assert.notNull(topic.getTid(), "not insert");
    }

    @Test
    public void testDelete() {
        topicService.delete(1);
    }


}
