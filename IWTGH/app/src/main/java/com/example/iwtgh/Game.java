package com.example.iwtgh;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

public class Game extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_game);
        TextView tvTitle = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        tvTitle.setText(intent.getStringExtra("title"));

        String m = intent.getStringExtra("title");

        switch(m){
            case "고고베베 - 마마무":
                Music a1 = new Music(this, "gogobebe", false);
                //GameObject를 만들고 그 안에서 노래를 스탑시키고 나옴
                break;
            case "답을 찾지 못한 날 - 윤하":
                new Music(this, "nodab", false);
                break;
            case "STAY - BlackPink":
                new Music(this, "stay", false);
                break;
            case "Perfect - Ed Sheeran":
                new Music(this, "perfect", false);
                break;
            case "Bad guy - Billie Eilish":
                new Music(this, "badguy", false);
                break;
        }

    }
}
