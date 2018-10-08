package com.marketplaces.www.orchestrator;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.marketplaces.www.enums.QueueNames;
import com.marketplaces.www.service.SMSDequeueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class Orchestrator implements Runnable {

    @Autowired
    SMSDequeueService smsDequeueService;

    @PostConstruct
    public void init() {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        dequeue(QueueNames.TRANSACTIONAL.toString(), 4);
        dequeue(QueueNames.PROMOTIONAL_HIGH.toString(), 3);
        dequeue(QueueNames.PROMOTIONAL_MED.toString(), 2);
        dequeue(QueueNames.PROMOTIONAL_LOW.toString(), 1);
    }

    private void dequeue(String queue, int limit) {
        Set<SMSRequestDTO> dequeueSet = smsDequeueService.dequeue(queue, limit);
        dequeueSet.stream().forEach(t -> System.out.println(t.getMessage()));
    }
}

