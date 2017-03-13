package com.hyperion.framework.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Johnny Huang on 2016/1/21
 */
public class LogcatUtil {

    public static ArrayList<String> getLogcatOut(String filter) {
        ArrayList<String> results = new ArrayList<>();
        String cmd = "su -c logcat -d -t 2000 *:I";
        Process process;
        BufferedReader br;
        String line;
        try {
            process = Runtime.getRuntime().exec(cmd);
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while((line = br.readLine())!=null){
                if (line.contains(filter)) {
                results.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
