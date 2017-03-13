package com.hyperion.framework.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Johnny Huang on 2016/1/21
 */
public class ResultCollect {

    private static final String SERVER_URL = "http://telenav-90328:3000/cases/";
    private Context ctx;
    private Handler handler;

    public ResultCollect(Context ctx, Handler handler){
        this.ctx = ctx;
        this.handler = handler;
    }

    private void getResultJsonThread(){
        new Thread() {
            public void run() {
                try {
                    URL url = new URL(SERVER_URL + "previous/" + Build.SERIAL);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    if (200 == urlConnection.getResponseCode()) {
                        InputStream is = urlConnection.getInputStream();
                        ByteArrayOutputStream bs = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int len;
                        while (-1 != (len = is.read(buffer))) {
                            bs.write(buffer, 0, len);
                            bs.flush();
                        }
                        Message msg = new Message();
                        msg.what = 1;
                        Bundle bundle = new Bundle();
                        bundle.putString("ret", bs.toString("utf-8"));
                        msg.setData(bundle);
                        handler.sendMessage(msg);
                        return;
                    }
                } catch (Exception e) {
                }
                handler.sendEmptyMessage(4);
            }
        }.start();
    }

    private boolean getWifiStatus(){
        WifiManager wManager = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
        return wManager.isWifiEnabled();
    }

    private void openWifi(){
        WifiManager wManager = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
        if (!wManager.isWifiEnabled()) {
            wManager.setWifiEnabled(true);
            for(int i = 0; i < 10; i ++){
                if(!wManager.isWifiEnabled()){
                    SystemClock.sleep(3000);
                } else {
                    break;
                }
            }
        }
    }

    private void closeWifi(){
        WifiManager wManager = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
        if (wManager.isWifiEnabled()) {
            wManager.setWifiEnabled(false);
            for(int i = 0; i < 10; i ++){
                if(wManager.isWifiEnabled()){
                    SystemClock.sleep(3000);
                } else {
                    break;
                }
            }
        }
    }

    private void showOpenWifiDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("WIFI disconnected!");
        builder.setMessage("Confirm to connect WIFI!");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                openWifi();
                handler.sendEmptyMessage(3);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                handler.sendEmptyMessage(2);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public boolean checkWifiStatus(){
        if(!getWifiStatus()){
            showOpenWifiDialog();
            return false;
        }
        return true;
    }

    public void getResultFromServer(){
        if(getWifiStatus()){
            getResultJsonThread();
        }else{
            handler.sendEmptyMessage(2);
        }
    }
}
