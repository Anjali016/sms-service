package com.marketplaces.www.repo;

import com.marketplaces.www.dto.SMSRequestDTO;

import java.util.Queue;

public interface SmsRepository {

  void storeMessage(SMSRequestDTO message, String queue);

  SMSRequestDTO getMessage(String number);

  void updateMessage(SMSRequestDTO message);

  void deleteMessage(String number);

  Queue<SMSRequestDTO> pop(String queue);
}
