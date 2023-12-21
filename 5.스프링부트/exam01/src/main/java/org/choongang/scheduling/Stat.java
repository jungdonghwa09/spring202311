package org.choongang.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class Stat {
    @Scheduled(cron="*/3 * * * * *")//3초마다
    public void orderStatProcess(){
       log.info("주문 통계 진행....");
    }
}
