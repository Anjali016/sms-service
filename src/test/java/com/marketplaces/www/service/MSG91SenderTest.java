package com.marketplaces.www.service;

import com.marketplaces.www.dto.SMSRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class MSG91SenderTest {

  MSG91Sender msg91Sender = new MSG91Sender();

  @Test
  void sendSms() {
    SMSRequestDTO smsRequestDTO = new SMSRequestDTO();
    smsRequestDTO.setMsisdn("7349094434");
    smsRequestDTO.setMessage("sendSMS test case");
    smsRequestDTO.setPriority("high");
    smsRequestDTO.setType("Promotional");

    String string = msg91Sender.sendSms(smsRequestDTO);
    System.out.println(string);
  }
}
