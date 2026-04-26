package com.global.hr.booksproject.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

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
