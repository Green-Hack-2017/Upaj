package com.zeeshan.pradeep.kartik.upaj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LaunchActivity extends AppCompatActivity {


    private static final int MOBILE_NO_LENGTH = 10;
    EditText mAadharEditText;
    Button mProceedButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);


        mAadharEditText = (EditText) findViewById(R.id.mobileEditText);
        mProceedButton = (Button) findViewById(R.id.proceedButton);


        mProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = mAadharEditText.getText().toString();

                if (inputText.length() != MOBILE_NO_LENGTH)
                {
                    Toast.makeText(getApplicationContext(), "please enter a proper mobile no", Toast.LENGTH_SHORT).show();

                }
                else{
                    ((Upaj) getApplication()).setmMobNo(inputText);
                    authenticate(inputText);

                }
            }
        });




    }

    /**
     * needs to go to OTP activity and do stuff
     * @param inputText
     */
    private void authenticate(String inputText) {
        //TODO:needs to be implemented
        Intent intent = new Intent(this,OTPActivity.class);
        startActivity(intent);

    }
}
