package com.zeeshan.pradeep.kartik.upaj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPagerFragment savedFragment = (ViewPagerFragment) getSupportFragmentManager().findFragmentByTag(VIEWPAGER_FRAGMENT);
        if(savedFragment==null) {
            ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeholder, viewPagerFragment,VIEWPAGER_FRAGMENT);
            fragmentTransaction.commit();
        }
    }
}
