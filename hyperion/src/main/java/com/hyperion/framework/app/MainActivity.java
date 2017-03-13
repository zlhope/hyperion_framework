package com.hyperion.framework.app;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v4.app.ActivityCompat;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyperion.framework.app.cache.CacheData;
import com.hyperion.framework.app.cache.CacheManager;
import com.hyperion.framework.app.cache.CacheUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends Activity {
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private TextToSpeech mSpeech = null;
    private Button bt;
    private TextView tv;
    private EditText et;
    private ImageView iv;
    private Context mContext;
    private CaseIDParser caseIDParser;
    private ResultCollect resultCollect;

    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(this);
        mSpeech = new TextToSpeech(this, new TTSListener());
        mContext = this;
        caseIDParser = new CaseIDParser(mContext);
        resultCollect = new ResultCollect(mContext, mHandler);
        initView();
    }

    private class TTSListener implements OnInitListener {
        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                int result = mSpeech.setLanguage(Locale.ENGLISH);
                if (result == TextToSpeech.LANG_MISSING_DATA
                        || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    System.out.println("Language is not supported!");
                }
            }
            getResults();
        }
    }

    @Override
    protected void onDestroy() {
        if (mSpeech != null) {
            mSpeech.stop();
            mSpeech.shutdown();
            mSpeech = null;
        }
        super.onDestroy();
    }

    private void setOutputText(String str, Boolean speechFlag){
        tv.append(Html.fromHtml("  \\\\:> " + str + "<br>"));
        if(speechFlag){
            mSpeech.speak(str, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    private void setOutputText(String str, Boolean speechFlag, String color){
        String strHtml = "<font color=\"" + color + "\">" + str + "</font>";
        tv.append(Html.fromHtml("  \\\\:> " + strHtml + "<br>"));
        if(speechFlag){
            mSpeech.speak(str, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    private void initView(){
        bt = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        iv = (ImageView) findViewById(R.id.imageView2);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        bt.setTextSize(40);
        bt.setTextColor(Color.GREEN);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String caseID = et.getText().toString();
                    if(caseID.equals("")){
                        setOutputText("Please input case ID!", true, "red");
                        return;
                    }
                    String caseInfo = caseIDParser.getClassMethod(caseID);;
                    if(caseInfo != null){
                        TaskThread t = new TaskThread(caseInfo);
                        t.start();
                    }else{
                        setOutputText("Cannot find case [" + caseID + "] , please check again!", true , "red");
                        SystemClock.sleep(4000);
                        ArrayList<String> result = caseIDParser.getSimilarMethod(caseID);
                        if(result.size() != 0) {
                            setOutputText("You maybe want to run the following cases!", true, "green");
                            for (String caseName : result) {
                                setOutputText(caseName, false, "green");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutputText("Total cases count is: " +
                        caseIDParser.getClassMethods("DP_").size() + "." ,true);
                SystemClock.sleep(3000);
                setOutputText("And you can try the following toolkit!" ,true , "green");
                for(String caseName: caseIDParser.getClassMethods("TK_")){
                    setOutputText(caseName, false, "green");
                }
                while (tv.canScrollVertically(1)) {
                    tv.scrollBy(0, 10);
                }
            }
        });
        initEditView();
    }

    private void initEditView(){
        et = (EditText) findViewById(R.id.editText);
        et.setCursorVisible(false);
        et.setOnTouchListener(new EditText.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    et.setCursorVisible(true);
                }
                return false;
            }
        });
        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    et.setCursorVisible(false);
                }
                return false;
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void getResults(){
        CacheManager.init(this);
        CacheData first_flag = CacheManager.getInstance().getCache(CacheUtils.KEY_TEST);
        if (first_flag == null){
            setOutputText("Hyperion framework initialized...", true, "green");
            CacheManager.getInstance().addCache(new CacheData(CacheUtils.KEY_TEST, "true"));
            return;
        }
        Boolean status = resultCollect.checkWifiStatus();
        if(status){
            mHandler.sendEmptyMessage(3);
        }else{
            mHandler.sendEmptyMessage(5);
        }
    }

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    setCaseResult(msg.getData().getString("ret"));
                    break;
                case 2:
                    setOutputText("WIFI is disconnected, you cannot get case result!", true, "red");
                    break;
                case 3:
                    resultCollect.getResultFromServer();
                    break;
                case 4:
                    setOutputText("Warning! Hyperion Server has internal error!", true, "red");
                    break;
                case 5:
                    setOutputText("Please input case ID and click go button!", true);
                    break;
                default:
                    break;
            }
        }
    };

    private void setCaseResult(String data){
        try {
            JSONObject jsonObject = new JSONObject(data);
            if(jsonObject.has("id")){
                setOutputText("Last executed case: [" + jsonObject.getString("case_name") + "]", false);
                if(jsonObject.getString("result").equals("passed")) {
                    setOutputText("Case result: [" + jsonObject.getString("result") + "]", true, "green");
                    return;
                }else{
                    setOutputText("Case result: [" + jsonObject.getString("result") + "]", true, "red");
                }
                if(jsonObject.getString("detail") != null){
                    setOutputText("Cause: " + jsonObject.getString("detail"), false, "red");
                }
            }else{
                mHandler.sendEmptyMessage(5);
            }
        }catch (Exception e){
        }
    }
}
