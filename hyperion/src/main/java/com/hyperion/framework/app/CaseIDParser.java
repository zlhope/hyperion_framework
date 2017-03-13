package com.hyperion.framework.app;

import android.content.Context;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;

import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;

public class CaseIDParser {

    private Context context = null;
    private String apkName;
    private String PACKAGE_TEST = "com.hyperion.framework.app.test";
    private static ArrayList<String> CLASS_LIST = new ArrayList<>();
    private static ArrayList<String> METHOD_LIST = new ArrayList<>();
    String dexOutputPath;

    public CaseIDParser(Context context){
        this.context = context;
        try {
            apkName = context.getPackageManager().getApplicationInfo(PACKAGE_TEST, 0).sourceDir;
        }catch (Exception e){
        }
    }

    public String getClassMethod(String caseID){
        String result = null;
        for (String m : getAllClassMethods()) {
            if (m.split("#")[1].split("_")[1].equals(caseID)) {
                result = m;
            }
        }
        return result;
    }

    public ArrayList<String> getClassMethods(String filter){
        ArrayList<String> result = new ArrayList<>();
        for (String m : getAllClassMethods()) {
            if (m.split("#")[1].contains(filter)) {
                result.add(m.split("#")[1]);
            }
        }
        return result;
    }

    public ArrayList<String> getAllClassMethods(){
        if(METHOD_LIST.size() == 0){
            dexOutputPath = context.getDir("dex", 0).getAbsolutePath();
            DexClassLoader dLoader = new DexClassLoader(apkName , dexOutputPath , null ,ClassLoader.getSystemClassLoader());
            ArrayList<String> ar = getCaseClasses();
            for(String c : ar) {
                try {
                    Class cLoad = dLoader.loadClass(c);
                    Method[] methods = cLoad.getMethods();
                    for (Method m : methods) {
                        if (m.getName().contains("DP_") ||
                                m.getName().contains("TK_")) {
                            METHOD_LIST.add(c + "#" + m.getName());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return METHOD_LIST;
    }

    private ArrayList<String> getCaseClasses(){
        if(CLASS_LIST.size() == 0){
            String tmpClassStr;
            try {
                DexFile df = DexFile.loadDex(apkName, dexOutputPath+"/testloadclass.odex", 0);
                Enumeration<String> iTer = df.entries();
                while (iTer.hasMoreElements()) {
                    tmpClassStr = iTer.nextElement();
                    if(tmpClassStr.contains("testcase.cases") &&
                            (!tmpClassStr.contains("CaseBase"))){
                        CLASS_LIST.add(tmpClassStr);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return CLASS_LIST;
    }

    public ArrayList<String> getSimilarMethod(String caseID){
        ArrayList<String> result = new ArrayList<>();
        for (String m : getAllClassMethods()) {
            String tmp = m.split("#")[1].split("_")[1];
            if (tmp.startsWith(caseID) ||
                    tmp.endsWith(caseID)) {
                result.add(m.split("#")[1]);
            }
        }
        if(caseID.length() == 3){
            String tmp21 = caseID.substring(0,2);
            ArrayList<String> result21 = getSimilarMethod(tmp21);
            String tmp12 = caseID.substring(1,3);
            ArrayList<String> result12 = getSimilarMethod(tmp12);
            for(String tmp : result21){
                if(!result.contains(tmp)){
                    result.add(tmp);
                }
            }
            for(String tmp : result12){
                if(!result.contains(tmp)){
                    result.add(tmp);
                }
            }
        }
        if(caseID.length() == 4){
            String tmp21 = caseID.substring(0,3);
            ArrayList<String> result21 = getSimilarMethod(tmp21);
            String tmp12 = caseID.substring(1,4);
            ArrayList<String> result12 = getSimilarMethod(tmp12);
            for(String tmp : result21){
                if(!result.contains(tmp)){
                    result.add(tmp);
                }
            }
            for(String tmp : result12){
                if(!result.contains(tmp)){
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}