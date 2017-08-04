package com.zeeshan.pradeep.kartik.upaj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zeeshan.pradeep.kartik.upaj.R;

/**
 * Created by kartik on 16/8/16.
 */
public class ViewPagerFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //when we are dealing with fragments within frgments we need to use childFragmentManager
        ViewPager viewPager = (ViewPager) getView().findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                //return position==0 ? ingredientsFragment:directionsFragment;
                return null;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position==0?"Ingredients":"Directions";
            }

            @Override
            public int getCount() {
                return 3; // 1 for ingredients + 1 for directions
            }
        });

        TabLayout tabLayout = (TabLayout) getView().findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);


        return getView();
    }


    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));

    }
}