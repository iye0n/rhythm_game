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
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static com.example.iwtgh.R.id.basicnode;

class MyView extends View {

    float x = 0, y = 0;

    private Runnable createRunnable(final int i){

        Runnable aRunnable = new Runnable(){
            public void run(){

            }
        };

        return aRunnable;

    }

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
        canvas.drawBitmap(bit, x, y,null);
    }
}

class GameObject{

    MyView mv;
    Music m;
    GameObject(MyView mv1, String Songtype, final Music a) throws InterruptedException {
        mv = mv1;
        m = a;
        //gogo();
    }

    public void drop(final MyView mv, Handler handler, String Nodetype, final int start, final int speed) throws InterruptedException {

        switch(Nodetype){
            case "1":
                mv.x = 300; mv.y = 50;
                break;
            case "2":
                mv.x = 630; mv.y = 50;
                break;
            case "3":
                mv.x = 950; mv.y = 50;
                break;
            case "4":
                mv.x = 1270; mv.y = 50;
        }

        Log.d("Hello","Hello");

        //final Handler handler = new Handler();
        for (int i = 0; i < 5; i++) {
            final int thisi = i;
            final float thisx = mv.x;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.d("Hello",String.format("postDelayed %d %d %d:", thisi, start, speed));
                    mv.x = thisx;
                    mv.y = mv.y + (float) 50;
                    mv.invalidate();
                }
            }, start + i * speed);
        }

        //handler.removeMessages(0);

        /*handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 2000);*/
    }

    public void gogo(){
        try {
            final Handler handler = new Handler();
            drop(mv,  handler,"1", 3000, 100);
            drop(mv,  handler,"3", 10100, 100);
            drop(mv,  handler,"4", 15200, 100);

//            while(true);

//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        GameObject.drop(mv, "4");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }, 2000);
            //handler.removeMessages(0);

//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        GameObject.drop(mv, "3");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }, 4000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                m.stopMusic();
            }
        }, 30000);
    }
}


public class Game extends Activity {

    GameObject gameobject;

    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView tvTitle = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        tvTitle.setText(intent.getStringExtra("title"));

        String m = intent.getStringExtra("title");
        // Intent i = new Intent(getApplicationContext(), Node.class);

        MyView mv;
        setContentView(R.layout.activity_game);
        mv = (MyView) findViewById(basicnode);
        switch (m) {
            case "고고베베 - 마마무":
                Music a1 = new Music(this, "gogobebe", false);
                mv.invalidate();
                try {
                    gameobject = new GameObject(mv, "4", a1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //GameObject를 만들고 그 안에서 노래를 스탑시키고 나옴
                break;
            case "답을 찾지 못한 날 - 윤하":
                Music a2 = new Music(this, "nodab", false);
                mv.invalidate();
                try {
                    gameobject = new GameObject(mv, "4", a2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "STAY - BlackPink":
                Music a3 = new Music(this, "stay", false);
                mv.invalidate();
                try {
                    gameobject = new GameObject(mv, "4", a3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "Perfect - Ed Sheeran":
                Music a4 = new Music(this, "perfect", false);
                mv.invalidate();
                try {
                    gameobject = new GameObject(mv, "4", a4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "Bad guy - Billie Eilish":
                Music a5 = new Music(this, "badguy", false);
                mv.invalidate();
                try {
                    gameobject = new GameObject(mv, "4", a5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Hello", "World");
        gameobject.gogo();
    }
}