package com.marketplaces.www.controller;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.marketplaces.www.service.SMSEnqueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Queue;

@RestController
public class SMSController {

  @Autowired private SMSEnqueueService smsEnqueueService;

  @RequestMapping(method = RequestMethod.POST, value = "v1/sms/send")
  void send(@RequestBody List<SMSRequestDTO> message) {
    for (SMSRequestDTO sms : message) smsEnqueueService.enqueue(sms);
  }

  @RequestMapping("v1/sms/pop/{queue}")
  Queue<SMSRequestDTO >pop(@PathVariable String queue){
   return smsEnqueueService.dequeue(queue);
  }
}
