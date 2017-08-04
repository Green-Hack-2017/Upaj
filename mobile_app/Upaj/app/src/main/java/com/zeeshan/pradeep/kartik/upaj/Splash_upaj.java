package com.zeeshan.pradeep.kartik.upaj;

/**
 * Created by kartik on 4/8/17.
 */

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.ImageView;
        import android.os.Handler;

public class Splash_upaj extends Activity{

    ImageView Iv_splash;
    int splash_timeout = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_upaj);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_upaj.this, LaunchActivity.class);
                startActivity(i);
            }
        },splash_timeout);
    }

}
