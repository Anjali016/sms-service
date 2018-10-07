package com.marketplaces.www.repo;

import com.marketplaces.www.dto.SMSRequestDTO;

import java.util.Queue;
import java.util.Set;

public interface SmsRepository {

  void storeMessage(SMSRequestDTO message, String queue);

  SMSRequestDTO getMessage(String number);

  void updateMessage(SMSRequestDTO message);

  void deleteMessage(String number);

  Set<SMSRequestDTO> dequeue(String queue);
}
