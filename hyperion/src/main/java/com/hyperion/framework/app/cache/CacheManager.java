package com.hyperion.framework.app.cache;

/**
 * Created by jnhuang on 12/13/2016
 */
import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CacheManager {
    private static CacheManager instance;
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    private CacheManager() {

    }

    public static CacheManager getInstance() {
        if (instance == null) instance = new CacheManager();
        return instance;
    }

    public void addCache(CacheData cacheData) {
        if (cacheData == null) return;
        try {
            File file = new File(mContext.getCacheDir(), cacheData.getKey());
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(cacheData);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CacheData getCache(String key) {
        try {
            File file = new File(mContext.getCacheDir(), key);
            if (file == null || (!file.exists())) return null;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            CacheData cacheData = (CacheData) ois.readObject();
            ois.close();
            if (cacheData.isValid()) return cacheData;
        } catch (Exception e) {
        }
        return null;
    }
}
