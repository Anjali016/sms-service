package com.marketplaces.www.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class HttpUtilTest {

  @Test
  void sendRequest() throws UnsupportedEncodingException {
    String url = "http://api.msg91.com/api/sendhttp.php?";
    StringBuilder sbPostData = new StringBuilder(url);
    sbPostData.append("authkey=" + "241722AiJ6fVDckP5bbb23fa");
    sbPostData.append("&mobiles=" + "7349094434");
    sbPostData.append("&message=" + URLEncoder.encode("bholu", "utf-8"));
    sbPostData.append("&route=" + "default");
    sbPostData.append("&sender=" + "marketplace");
    String post = sbPostData.toString();
    try {
      String messageId = HttpUtil.sendRequest(post, "");
      System.out.println(messageId);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
