package com.marketplaces.www.utils;

import com.marketplaces.www.dto.SMSRequestDTO;
import com.sun.deploy.net.HttpResponse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpUtility {

    public void sendRequest(String httpUrl, SMSRequestDTO smsRequestDTO) throws IOException {
        URL url = new URL(httpUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-type", "application/json");

        //httpURLConnection.getOutputStream().write(postData.getBytes());

        String postData =
                "&"+URLEncoder.encode("TP-MKTPLC") + "&" + "country=" + "91";
        /*HttpResponse<String> response = Unirest.post("http://api.msg91.com/api/v2/sendsms?campaign=&response=&afterminutes=&schtime=&unicode=&flash=&message=&encrypt=&authkey=&mobiles=&route=&sender=&country=91")
                .header("authkey", "")
                .header("content-type", "application/json")
                .body("{ \"sender\": \"SOCKET\", \"route\": \"4\", \"country\": \"91\", \"sms\": [ { \"message\": \"Message1\", \"to\": [ \"98260XXXXX\", \"98261XXXXX\" ] }, { \"message\": \"Message2\", \"to\": [ \"98260XXXXX\", \"98261XXXXX\" ] } ] }")
                .asString();*/


//        String postData = "message=" + smsRequestDTO.getMessage() + "&" + "authkey=" + "241722AiJ6fVDckP5bbb23fa" + "&" +
//                "mobiles=" + smsRequestDTO.getMsisdn() + "&" + "route=" + "44" + "&" + "sender=" + "TP-MKTPLC" + "&" + "country=" + "91";
    }


}
