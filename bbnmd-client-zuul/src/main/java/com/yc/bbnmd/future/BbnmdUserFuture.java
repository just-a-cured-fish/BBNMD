package com.yc.bbnmd.future;

import com.yc.bbnmd.entity.User;
import com.yc.bbnmd.service.UserRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

// 对外公开的业务层
@Component
public class BbnmdUserFuture {
    @Autowired
    private UserRestService userRestService;

    @Async
    public CompletableFuture<String> findById(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            return userRestService.findById(id);
        });
    }


    @Async
    public CompletableFuture<String> create(User user) {
        return CompletableFuture.supplyAsync(() -> {
            return userRestService.create(user);
        });
    }


    @Async
    public CompletableFuture<String> delete(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            return userRestService.delete(id);
        });
    }
}
