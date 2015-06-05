package com.example.ka4tik.stromy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String api_key="d162e457e174aa85b8b40e85dc69ff75";
        double latitude=37.8267;
        double longitude=-122.423;
        String forcastUrl = "https://api.forecast.io/forecast/"+api_key+"/"+latitude+","+longitude;

        OkHttpClient client=new OkHttpClient();
        final Request request=new Request.Builder()
                .url(forcastUrl)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                try {
                    if (response.isSuccessful()) {
                        Log.v(TAG,response.body().string());
                    }
                }catch (Exception e)
                {
                    Log.e(TAG,"Exception caught: ",e);
                }


            }
        });

    }

}
