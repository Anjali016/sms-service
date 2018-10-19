package com.marketplaces.www.orchestrator;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.marketplaces.www.service.MSG91Sender;
import org.springframework.beans.factory.annotation.Autowired;

public class SendSMSTask implements Runnable {

  @Autowired MSG91Sender msg91Sender;
  private SMSRequestDTO smsRequestDTO;

  SendSMSTask(SMSRequestDTO smsRequestDTO) {
    this.smsRequestDTO = smsRequestDTO;
  }

  @Override
  public void run() {
    System.out.println("Sms send task invoked!");
    String messageId = msg91Sender.sendSms(smsRequestDTO);
    System.out.println("messageId : " + messageId);
  }
}
