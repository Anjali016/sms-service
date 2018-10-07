package com.marketplaces.www.dto;

import java.io.Serializable;

public class SMSRequestDTO implements Serializable {
  private String msisdn;
  private String type;
  private String message;
  private String priority;

  public String getMsisdn() {
    return this.msisdn;
  }

  public void setMsisdn(String msisdn) {
    this.msisdn = msisdn;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPriority() {
    return this.priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }
}
