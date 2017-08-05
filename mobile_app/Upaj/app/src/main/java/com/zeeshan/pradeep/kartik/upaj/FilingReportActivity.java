package com.zeeshan.pradeep.kartik.upaj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

public class FilingReportActivity extends AppCompatActivity {

    private static final String CURRENT_IMAGE_PATH = "current_image_path";
    private static final String AADHAR_NO = "aadhar_no";
    private static final String IMAGE_DATA = "image_data";


    ImageView mCurrentPhotoImageView;
    Button mSendRequestButton;
    EditText mProblemEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filing_report);

        mCurrentPhotoImageView = (ImageView) findViewById(R.id.currentPhotoImageView);
        mProblemEditText = (EditText) findViewById(R.id.problemEditText);

        String imagePath=getIntent().getStringExtra(CURRENT_IMAGE_PATH);


        Bitmap bmImg = BitmapFactory.decodeFile(String.valueOf(imagePath));
        mCurrentPhotoImageView.setImageBitmap(bmImg);

        mSendRequestButton = (Button) findViewById(R.id.sendRequestButton);


        mSendRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestDataToServer();
            }
        });


    }

    private void sendRequestDataToServer() {
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put(AADHAR_NO,"placeholder");
            jsonObject.put(IMAGE_DATA,new byte[20]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
    }
}
