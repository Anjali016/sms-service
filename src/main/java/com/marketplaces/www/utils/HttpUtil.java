package com.marketplaces.www.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpUtil {

  public static String sendRequest(String httpUrl, String postData) throws IOException {
    URL url = new URL(httpUrl);
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.setRequestMethod("POST");
    httpURLConnection.setDoOutput(true);
    httpURLConnection.setUseCaches(false);
    try (DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream())) {
      wr.write(postData.getBytes(StandardCharsets.UTF_8));
    }
    BufferedReader br =
        new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));
    String output;
    String result = "";
    System.out.println("Output from Server .... \n");
    while ((output = br.readLine()) != null) {
      result += output;
    }
    httpURLConnection.disconnect();
    return result;
  }
}
