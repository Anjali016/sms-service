package com.marketplaces.www.dto;

import java.util.List;

public class SMSPayloadDTO {
  private String sender;
  private String route;
  private String country;
  private List<Sms> sms;

  public String getSender() {
    return this.sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getRoute() {
    return this.route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public List<Sms> getSms() {
    return this.sms;
  }

  public void setSms(List<Sms> sms) {
    this.sms = sms;
  }
}
