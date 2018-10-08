package com.marketplaces.www.orchestrator;

import com.marketplaces.www.controller.HealthController;
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
    HealthController healthController;
    int poolSize = 100;
    ExecutorService executorService = Executors.newFixedThreadPool(poolSize);

    @Autowired
    SMSDequeueService smsDequeueService;

    Orchestrator() {
    }

    @PostConstruct
    public void init() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        //while (healthController.status) {
            try {
                System.out.println("Started consuming sms batch!");
                dequeue(QueueNames.TRANSACTIONAL.toString(), 4);
                dequeue(QueueNames.PROMOTIONAL_HIGH.toString(), 3);
                dequeue(QueueNames.PROMOTIONAL_MED.toString(), 2);
                dequeue(QueueNames.PROMOTIONAL_LOW.toString(), 1);
                Thread.sleep(2000);
                while (!healthController.status) {
                    System.out.println("Service is marked down. Not consuming sms batch");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
      //  }
    }

    private void dequeue(String queue, int limit) {
        Set<SMSRequestDTO> dequeueSet = smsDequeueService.dequeue(queue, limit);
        if (!dequeueSet.isEmpty())
            dequeueSet.forEach(t -> executorService.submit(new SendSMSTask(t)));
    }
}

