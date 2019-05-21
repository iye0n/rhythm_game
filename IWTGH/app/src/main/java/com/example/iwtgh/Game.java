package com.example.iwtgh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import static com.example.iwtgh.R.id.basicnode;

class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet att) {
        super(context, att);
    }

    public MyView(Context context, AttributeSet att, int a) {
        super(context, att, a);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onDraw(Canvas canvas){
        BitmapDrawable basicn = null;
        basicn =(BitmapDrawable) getResources().getDrawable(R.drawable.nodebasic, null);
        Bitmap bit = basicn.getBitmap();
        canvas.drawBitmap(bit,300,100,null);
    }
}

public class Game extends Activity {
    MyView mv;
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView tvTitle = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        tvTitle.setText(intent.getStringExtra("title"));

        String m = intent.getStringExtra("title");
        // Intent i = new Intent(getApplicationContext(), Node.class);

        switch (m) {
            case "고고베베 - 마마무":
                setContentView(R.layout.activity_game);
                Music a1 = new Music(this, "gogobebe", false);
                mv = (MyView) findViewById(basicnode);
                mv.invalidate();
                //GameObject를 만들고 그 안에서 노래를 스탑시키고 나옴
                break;
            case "답을 찾지 못한 날 - 윤하":
                Music a2 = new Music(this, "nodab", false);
                mv = (MyView) findViewById(basicnode);
                mv.invalidate();
                break;
            case "STAY - BlackPink":
                Music a3 = new Music(this, "stay", false);
                mv = (MyView) findViewById(basicnode);
                mv.invalidate();
                break;
            case "Perfect - Ed Sheeran":
                Music a4 = new Music(this, "perfect", false);
                mv = (MyView) findViewById(basicnode);
                mv.invalidate();
                break;
            case "Bad guy - Billie Eilish":
                Music a5 = new Music(this, "badguy", false);
                mv = (MyView) findViewById(basicnode);
                mv.invalidate();
                break;
        }
    }

}