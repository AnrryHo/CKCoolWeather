package cn.yixg.ckcoolweather;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Anry on 2019/9/9.
 */
public class MyApplication extends org.litepal.LitePalApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(getApplicationContext());
    }
}
