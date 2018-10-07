package com.marketplaces.www.service;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.marketplaces.www.repo.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SMSEnqueueService {

    @Autowired
    private SmsRepository smsRepository;

    private static final String transactionalQueue = "transactional";
    private static final String promotionalHighQueue = "promotionalHigh";
    private static final String promotionalMedQueue = "promotionalMed";
    private static final String promotionalLowQueue = "promotionalLow";

    public void enqueue(SMSRequestDTO smsRequestDTO) {
        smsRepository.storeMessage(smsRequestDTO, getQueue(smsRequestDTO));
    }

    private String getQueue(SMSRequestDTO smsRequestDTO) {
        if (smsRequestDTO.getType().equalsIgnoreCase("transactional")) return transactionalQueue;
        else if (smsRequestDTO.getPriority().startsWith("high")) return promotionalHighQueue;
        else if (smsRequestDTO.getPriority().startsWith("medium")) return promotionalMedQueue;
        return promotionalLowQueue;
    }

    public Set<SMSRequestDTO> dequeue(String queue) {
        return smsRepository.dequeue(queue);
    }
}
