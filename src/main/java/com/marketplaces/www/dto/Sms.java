package com.marketplaces.www.dto;

import org.springframework.beans.factory.annotation.Autowired;

public class Sms {

    @Autowired
    SMSRequestDTO smsRequestDTO;

    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String to;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
