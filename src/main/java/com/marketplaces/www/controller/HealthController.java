package com.marketplaces.www.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HealthController {

  private boolean status = true;

  @RequestMapping("/v1/health/status")
  public HttpStatus status() {
    if (status) return HttpStatus.OK;
    else return HttpStatus.SERVICE_UNAVAILABLE;
  }

  @RequestMapping("/v1/health/markUp")
  public HttpStatus markUp() {
    status = true;
    return HttpStatus.OK;
  }

  @RequestMapping("/v1/health/markDown")
  public HttpStatus markDown() {
    status = false;
    return HttpStatus.OK;
  }
}
