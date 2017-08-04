package com.zeeshan.pradeep.kartik.upaj;


import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment {

Button mCallHelpLineButton;

    public HelpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help, container, false);
        mCallHelpLineButton = (Button) view.findViewById(R.id.callButton);


        mCallHelpLineButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String number = "5464564646546";
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));
                startActivity(callIntent);
            }

        });

        return view;
    }


}
