package com.yc;


import com.yc.bbnmd.entity.Replay;
import com.yc.bbnmd.entity.User;
import com.yc.bbnmd.service.ReplayService;
import com.yc.bbnmd.service.UserService;
import com.yc.bbnmd.util.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfiguration.class})
public class TestReplayService {

    private static final Logger logger = Logger.getLogger(TestReplayService.class.getName());

    @Autowired
    private ReplayService replayService;



    @Test
    public void testFindOne() {
        Replay replay = new Replay();
        replay.setRid(3);
        logger.info("调用replayService.findOne");
        Replay replaybean = replayService.findOne(replay.getRid());
        System.out.println(replaybean);
    }

    @Test
    public void testSave() {
        Random r=new Random();
        Replay replay = new Replay();
        replay.setContent("测试回复" + r.nextInt(9999));
        replay.setTid(2);
        replay.setTime(CommonUtils.formatDateTime(new Date()));
        replayService.save(replay);
        logger.info("新增的回复编号:" + replay.getRid());
        //断言.
        Assert.notNull(replay.getRid(), "not insert");
    }

    @Test
    public void testDelete() {
        replayService.delete(3);
    }


}
