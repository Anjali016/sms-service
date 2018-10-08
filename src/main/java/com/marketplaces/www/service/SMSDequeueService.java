package com.marketplaces.www.service;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.marketplaces.www.repo.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SMSDequeueService {

    @Autowired SmsRepository smsRepository;

    public Set<SMSRequestDTO> dequeue(String queue,int limit) {
        return smsRepository.dequeue(queue, limit);
    }
}
