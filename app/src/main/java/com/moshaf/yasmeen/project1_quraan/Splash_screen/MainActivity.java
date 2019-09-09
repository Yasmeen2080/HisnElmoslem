package com.moshaf.yasmeen.project1_quraan.Splash_screen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moshaf.yasmeen.project1_quraan.HomeActivity;
import com.moshaf.yasmeen.project1_quraan.R;

public class MainActivity extends AppCompatActivity {
    private static int splash_timeout = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();

            }
        }, splash_timeout);
    }
}
