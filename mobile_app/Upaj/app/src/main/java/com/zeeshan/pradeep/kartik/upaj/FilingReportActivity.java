package com.zeeshan.pradeep.kartik.upaj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FilingReportActivity extends AppCompatActivity {

    private static final String CURRENT_IMAGE_PATH = "current_image_path";

    ImageView mCurrentPhotoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filing_report);

        mCurrentPhotoImageView = (ImageView) findViewById(R.id.currentPhotoImageView);

        String imagePath=getIntent().getStringExtra(CURRENT_IMAGE_PATH);


        Bitmap bmImg = BitmapFactory.decodeFile(String.valueOf(imagePath));
        mCurrentPhotoImageView.setImageBitmap(bmImg);



    }
}
