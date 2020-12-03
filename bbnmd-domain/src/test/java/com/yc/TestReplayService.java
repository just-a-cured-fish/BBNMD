package com.yc;


import com.yc.bbnmd.entity.User;
import com.yc.bbnmd.service.UserService;
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
public class TestReplayService {

    private static final Logger logger = Logger.getLogger(TestReplayService.class.getName());

    @Autowired
    private UserService userService;



    @Test
    public void testFindOne() {
        User user = new User();
        user.setUid(1);
        logger.info("调用UserService.findOne");
        User userbean = userService.findOne(user.getUid());
        System.out.println(userbean);
    }

    @Test
    public void testSave() {
        Random r=new Random();
        User user = new User();
        user.setUname("测试用户" + r.nextInt(9999));
        user.setUpwd("a");
        userService.save(user);
        logger.info("新增的产品编号:" + user.getUid());
        //断言.
        Assert.notNull(user.getUid(), "not insert");
    }

    @Test
    public void testDelete() {
        userService.delete(1);
    }


}
