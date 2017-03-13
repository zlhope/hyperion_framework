package com.hyperion.framework.test.denali.utils;

import java.util.ArrayList;

/**
 * Created by Johnny Huang on 2016/1/21
 */
public class LogcatUtil {

    public ArrayList<String> getLogcatOut(String filter) throws HFObjectNotFoundException {
        ArrayList<String> results = new ArrayList<>();
        String cmd = "logcat -d -t 5000 *:I";
        try {
            String output = HFDevice.getDevice().executeShellCommand(cmd);
            for(String line : output.split("\\n")){
                if (line.contains(filter)) {
                results.add(line);
                }
            }
        } catch (Exception e) {
            HFLog.logMessage("Execute logcat command failed!");
        }
        return results;
    }

    public void clearAudioGuidance() throws HFObjectNotFoundException {
        try {
            HFDevice.getDevice().executeShellCommand("logcat -c");
        }catch (Exception e){
            HFLog.logMessage("Clear audio guidance failed!");
        }
    }
}
