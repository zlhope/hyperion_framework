package com.hyperion.framework.test.denali.utils;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Johnny Huang on 2016/1/21
 */
public class ServerHandler {
    private static final String SERVER_URL = "http://telenav-90328:3000";

    private static void uploadResult(String data){
        postAction(SERVER_URL + "/cases/add", data);
    }

    private static void postAction(String api,String data){
        try {
            URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection) url
                    .openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
            printWriter.write(data);
            printWriter.flush();
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
        }catch (Exception e){
            HFLog.logMessage("Post request failed!");
            HFLog.logMessage(e.getStackTrace());
        }
    }

    public static String getTestDataFromServer(String caseId){
        String ret = getAction(SERVER_URL + "/testdata/" + caseId);
        String result = null;
        try {
            JSONObject jsonObject = new JSONObject(ret);
            if (jsonObject.length()>0) {
                jsonObject = jsonObject.getJSONObject("0");
                result = jsonObject.getString("origin");
                result = result + "|" + jsonObject.getString("dest");
            }
        }catch (Exception e){
        }
        return result;
    }

    private static String getAction(String api){
        try {
            URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection) url
                    .openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (200 == conn.getResponseCode()) {
                InputStream is = conn.getInputStream();
                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while (-1 != (len = is.read(buffer))) {
                    bs.write(buffer, 0, len);
                    bs.flush();
                }
                return bs.toString("utf-8");
            }
        }catch (Exception e){
            HFLog.logMessage("Post request failed!");
            HFLog.logMessage(e.getStackTrace());
        }
        return "";
    }

    public static String getTestMode(){
        return HFDevice.getWifiStatus() ? "offboard": "onboard";
    }

    public static void uploadResultByClass(ArrayList<String> results){
        if(results.size() == 0){
            return;
        }
        Boolean wifiFlag = HFDevice.getWifiStatus();
        if(!wifiFlag){
            HFDevice.openWifi();
        }
        for(String data: results){
            uploadResult(data);
        }
        if(!wifiFlag){
            HFDevice.closeWifi();
        }
    }
}
