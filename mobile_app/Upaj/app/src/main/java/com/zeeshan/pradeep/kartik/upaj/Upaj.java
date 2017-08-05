package com.zeeshan.pradeep.kartik.upaj;

import android.app.Application;

/**
 * Created by kartik on 5/8/17.
 */

public class Upaj extends Application {
    private String mMobNo;

    Upaj(){
        mMobNo = "44444444444";
    }

    public String getmMobNo() {
        return mMobNo;
    }

    public void setmMobNo(String mMobNo) {
        this.mMobNo = mMobNo;
    }
}
