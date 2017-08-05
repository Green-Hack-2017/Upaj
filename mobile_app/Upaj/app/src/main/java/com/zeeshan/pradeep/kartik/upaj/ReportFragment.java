package com.zeeshan.pradeep.kartik.upaj;


import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReportFragment extends Fragment {


    private static final String TAG = ReportFragment.class.getSimpleName();
    private static final String CURRENT_IMAGE_PATH = "current_image_path";

    Button mReportButton;
    String mCurrentPhotoPath;

    private static final int REQUEST_IMAGE_CAPTURE = 1;


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

            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }

            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(getContext(),
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                //startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }






        }else{
            Log.d(TAG,"result of resolve activity is  null");
        }

    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent =  new Intent(getContext(),FilingReportActivity.class);
        intent.putExtra(CURRENT_IMAGE_PATH,mCurrentPhotoPath);
        startActivity(intent);
    }
}
