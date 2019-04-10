package datanapps.basicsample.ui;

import android.app.Application;

import datanapps.basicsample.utils.DNASharedPreferenceUtils;

public class BasicSampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DNASharedPreferenceUtils.init(this);
    }
}
