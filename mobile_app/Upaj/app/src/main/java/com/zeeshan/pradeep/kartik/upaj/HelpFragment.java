package com.zeeshan.pradeep.kartik.upaj;


import android.content.ActivityNotFoundException;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment {

    private static final String HELPLINE_NO = "9842155781185515";
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

                String number = HELPLINE_NO;
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));

                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.CALL_PHONE},
                            10);
                    Toast.makeText(getContext(),"Please press the button again",Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    try {
                        startActivity(callIntent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getContext(), "No number to call", Toast.LENGTH_SHORT).show();

                    }
                }
            }





        });

        return view;
    }


}
