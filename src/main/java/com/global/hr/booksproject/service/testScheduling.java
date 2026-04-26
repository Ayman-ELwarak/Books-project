package com.global.hr.booksproject.service;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class testScheduling {
    Logger logger = org.slf4j.LoggerFactory.getLogger(testScheduling.class);

//    @Async
//    @Scheduled(fixedRate = 2000) // cron = "0 0/1 * * * *"
//    public void printMsg() throws InterruptedException {
//        Thread.sleep(2000);
//
//        logger.info("hello scheduling" + LocalDateTime.now());
//    }
}
