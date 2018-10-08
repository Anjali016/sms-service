package com.marketplaces.www.service;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.marketplaces.www.enums.Priorities;
import com.marketplaces.www.enums.QueueNames;
import com.marketplaces.www.repo.SmsRepository;
import com.marketplaces.www.utils.HttpUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SMSEnqueueService {


    @Autowired
    private SmsRepository smsRepository;

    public void enqueue(SMSRequestDTO smsRequestDTO) {
        smsRepository.storeMessage(smsRequestDTO, getQueue(smsRequestDTO));
    }

    public String getQueue(SMSRequestDTO smsRequestDTO) {
        if (smsRequestDTO.getType().equalsIgnoreCase(QueueNames.TRANSACTIONAL.toString())) return QueueNames.TRANSACTIONAL.toString();
        else if (smsRequestDTO.getPriority().equalsIgnoreCase(Priorities.HIGH.toString())) return QueueNames.PROMOTIONAL_HIGH.toString();
        else if (smsRequestDTO.getPriority().equalsIgnoreCase(Priorities.MEDIUM.toString())) return QueueNames.PROMOTIONAL_MED.toString();
        return QueueNames.PROMOTIONAL_LOW.toString();
    }

}
