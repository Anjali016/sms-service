package com.marketplaces.www.orchestrator;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.marketplaces.www.utils.HttpUtility;

import java.io.IOException;

public class SendSMSTask implements Runnable {

    private SMSRequestDTO smsRequestDTO;

    private HttpUtility httpUtility;

    SendSMSTask(SMSRequestDTO smsRequestDTO) {
        this.smsRequestDTO = smsRequestDTO;
    }

    @Override
    public void run() {
        System.out.println("Sms send task invoked!");
        try {
            httpUtility.sendRequest("http://api.msg91.com/api/v2/sendsms?country=91",smsRequestDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(smsRequestDTO.getMessage());
    }


}
