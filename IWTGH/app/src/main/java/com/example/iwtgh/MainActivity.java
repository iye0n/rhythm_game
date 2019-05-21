package com.example.iwtgh;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //bgm

        m = MediaPlayer.create(this, R.raw.bgm);
        m.setLooping(true);
        m.start();
    }

    public void onClick(View view) {
        // 다음 화면 전개 코드
        switch (view.getId()){
            case R.id.start_button:
                // 스타트 -> 노래 목록 띄우기
                Intent sel = new Intent(getApplicationContext(), ListSong.class);

                startActivity(sel);
                break;
        }
    }
}

