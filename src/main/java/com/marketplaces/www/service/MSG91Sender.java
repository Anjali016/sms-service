package com.marketplaces.www.service;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.marketplaces.www.utils.HttpUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;

@Service
public class MSG91Sender {

  private static String url = "http://api.msg91.com/api/sendhttp.php?";
  private static String authKey = "241722AiJ6fVDckP5bbb23fa";
  private static String route = "default";

  public String sendSms(SMSRequestDTO smsRequestDTO) {
    String url = "http://api.msg91.com/api/sendhttp.php?";
    try {
      StringBuilder sbPostData = new StringBuilder(url);
      sbPostData.append("authkey=" + "241722AiJ6fVDckP5bbb23fa");
      sbPostData.append("&mobiles=" + smsRequestDTO.getMsisdn());
      sbPostData.append("&message=" + URLEncoder.encode(smsRequestDTO.getMessage(), "utf-8"));
      sbPostData.append("&route=" + "default");
      sbPostData.append("&sender=" + "marketplace");
      String post = sbPostData.toString();
      /*String post =
          url
              + "authkey="
              + authKey
              + "&mobiles="
              + smsRequestDTO.getMsisdn()
              + "&message="
              + URLEncoder.encode(smsRequestDTO.getMessage(), "utf-8")
              + "&route="
              + route
              + "&sender="
              + "marketplace";*/
      return HttpUtil.sendRequest(url, post);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}

