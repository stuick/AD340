package com.example.trafficreport;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class CameraLoader extends AsyncTaskLoader {

    public CameraLoader(Context context) {
        super(context);
    }
    @Nullable
    @Override
    public Object loadInBackground() {
        return NetworkUtils.getCameraInfo();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
