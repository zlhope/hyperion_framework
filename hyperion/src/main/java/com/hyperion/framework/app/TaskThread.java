package com.hyperion.framework.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaskThread extends Thread{
    private String cmd1 = "su -c am instrument -e class ";
    private String cmd2 = " -e trigger true -w com.hyperion.framework.app.test/android.support.test.runner.AndroidJUnitRunner";
    private String caseInfo;

    public TaskThread(String caseInfo){
        this.caseInfo = caseInfo;
    }

    @Override
    public void run() {

        try {
            Runtime.getRuntime().exec("logcat -c");
            String cmd = cmd1 + caseInfo + cmd2;
            System.out.println("Begin to start thread...");
            System.out.println("Execute command: " + cmd);
            Process ps = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}