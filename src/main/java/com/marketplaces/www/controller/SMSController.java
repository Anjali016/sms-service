package com.marketplaces.www.controller;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.marketplaces.www.service.SMSDequeueService;
import com.marketplaces.www.service.SMSEnqueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class SMSController {

    @Autowired private SMSDequeueService smsDequeueService;
    @Autowired private SMSEnqueueService smsEnqueueService;

    @RequestMapping(method = RequestMethod.POST, value = "v1/sms/send")
    void send(@RequestBody List<SMSRequestDTO> message) {
        for (SMSRequestDTO sms : message) smsEnqueueService.enqueue(sms);
    }

    /*@RequestMapping("v1/sms/get/{queue}")
    Set<SMSRequestDTO> dequeue(@PathVariable String queue) {
        return smsDequeueService.dequeue(queue);
    }*/
}
