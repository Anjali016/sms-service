package com.marketplaces.www.service;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.data.redis.core.ZSetOperations;


class SMSEnqueueServiceTest {

    @Test
    void getQueue() {
        SMSRequestDTO smsRequestDTO1 = new SMSRequestDTO("989347", "Promotional", "hilee", "high");
        SMSRequestDTO smsRequestDTO2 = new SMSRequestDTO("989347", "", "should return promotional", "low");
        SMSRequestDTO smsRequestDTO3 = new SMSRequestDTO("989347", "Promotional", "should return promotional", "medium");
        Assert.assertEquals("PROMOTIONAL_HIGH", new SMSEnqueueService().getQueue(smsRequestDTO1));
        Assert.assertEquals("PROMOTIONAL_LOW", new SMSEnqueueService().getQueue(smsRequestDTO2));
        Assert.assertEquals("PROMOTIONAL_MED", new SMSEnqueueService().getQueue(smsRequestDTO3));


    }
}