package com.example.iwtgh;

import android.annotation.SuppressLint;

import android.app.Activity;

import android.app.Notification;

import android.content.Intent;

import android.os.Bundle;

import android.os.Handler;

import android.os.Message;

import android.view.Window;

public class Loding extends Activity {

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loding);

        Handler handler = new Handler() {

            public void handleMessage(Message msg) {

                super.handleMessage(msg);

                //startActivity(intent);

                startActivity(new Intent(Loding.this, MainActivity.class));

                finish();

            }

        };

        handler.sendEmptyMessageDelayed(0, 3000); //3초후 화면전환

    }

}