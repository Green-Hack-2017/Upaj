package com.zeeshan.pradeep.kartik.upaj;


import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReportFragment extends Fragment {


    private static final String TAG = ReportFragment.class.getSimpleName();
    Button mReportButton;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_report, container, false);
        mReportButton= (Button) view.findViewById(R.id.reportButton);
        
        
        mReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage();

            }
        });
        
        
        return view;
    }

    private void captureImage() {

        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG,"Permission for camera requested");
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA},
                    5);
            Log.v(TAG,"Permission for camera granted");
            Toast.makeText(getContext(),"Please press the button again",Toast.LENGTH_SHORT).show();
            return;
        } else {
            try {
                dispatchTakePictureIntent();
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getContext(), "No camera application to handle the call", Toast.LENGTH_SHORT).show();

            }
        }


    }


    private void dispatchTakePictureIntent() {
        Log.v(TAG,"sending intent to take picture");

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            Log.d(TAG,"result of resolve activity is not null");
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }else{
            Log.d(TAG,"result of resolve activity is  null");
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent =  new Intent(getContext(),FilingReportActivity.class);
        startActivity(intent);
    }
}
