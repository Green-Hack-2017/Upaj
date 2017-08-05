package com.zeeshan.pradeep.kartik.upaj;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FilingReportActivity extends AppCompatActivity {

    private static final String CURRENT_IMAGE_PATH = "current_image_path";
    private static final String MOB_NO = "mob_no";
    private static final String IMAGE_DATA = "image_data";
    private static final String JSON_DATA = "json_data";
    private static final String TAG = FilingReportActivity.class.getSimpleName();
    private static final String PROBLEM_DESCRIPTION = "problem_description";
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


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


        final Bitmap bmImg = BitmapFactory.decodeFile(String.valueOf(imagePath));
        mCurrentPhotoImageView.setImageBitmap(bmImg);

        mSendRequestButton = (Button) findViewById(R.id.sendRequestButton);


        mSendRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestDataToServer(bmImg);
            }
        });


    }

    private void sendRequestDataToServer(Bitmap bmImg) {
        JSONObject jsonObject = new JSONObject();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmImg.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        Log.v(TAG,"mobile no. is "+ ((Upaj) this.getApplication()).getmMobNo() );

        try{
            jsonObject.put(MOB_NO,((Upaj) this.getApplication()).getmMobNo()  );
            jsonObject.put(PROBLEM_DESCRIPTION,mProblemEditText.getText().toString());
            jsonObject.put(IMAGE_DATA,encodedImage);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sendDataUsingOkhttp(jsonObject);

    }

    private void sendDataUsingOkhttp(JSONObject jsonObject) {

        Log.v(TAG,"json data is \n "+jsonObject.toString());
           OkHttpClient client = new OkHttpClient();


        RequestBody requestBody = RequestBody.create(JSON,jsonObject.toString());
   //             create(JSON, jsonObject);

            Request request = new Request.Builder()
                    .url("http://192.168.24.10/upaj/uploadreport.php")
                    .post(requestBody)
                    .build();



            client.newCall(request).enqueue(new Callback() {
                @Override public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"Some error occured ! Please try again"
                                    , Toast.LENGTH_LONG).show();

                        }
                    });

                }

                @Override public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                     Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    System.out.println(response.body().string());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"Thank you for your request ! " +
                                    " Our experts will reply back in a couple of days" , Toast.LENGTH_LONG
                            ).show();

                        }
                    });
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);



                }
            });

    }

}
