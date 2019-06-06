package com.example.iwtgh;

//import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static android.content.ContentValues.TAG;
import static com.example.iwtgh.MyView.iscore;


public class ShowScore extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_showscore);

        Intent getscore = getIntent();
        final TextView showscore =(TextView)findViewById(R.id.textView1);
//        String m = getscore.getStringExtra("score");
//        showscore.setText(getscore.getStringExtra("score"));
//        Log.d(TAG, "onCreate: score");
        showscore.setText(Integer.toString(iscore));

    }
}
