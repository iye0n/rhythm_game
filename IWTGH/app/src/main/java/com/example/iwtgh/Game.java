package com.example.iwtgh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.iwtgh.R.id.basicnode;

class MyView extends View {

    float x = 0, y = 0;
    float x1 = 0, y1 = 0;
    float x2 = 0, y2 = 0;
    float x3 = 0, y3 = 0;
    int v1 = 0, v2 = 0, v3 = 0, v4 = 0;
    protected static int iscore = 0;

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
        Bitmap bit1 = basicn.getBitmap();
        Log.d("Hello",String.format("check_in_ondraw %d %d %d %d:", v1, v2, v3, v4));
        if(v1 == 1){
            canvas.drawBitmap(bit, x, y,null);
            Log.d("Hello","1");
            v1 = 0;
        }
        if(v2 == 1){
            canvas.drawBitmap(bit1, x1, y1,null);
            Log.d("Hello","2");
            v2 = 0;
        }
        if(v3 == 1){
            canvas.drawBitmap(bit, x2, y2,null);
            v3 = 0;
        }
        if(v4 == 1){
            canvas.drawBitmap(bit, x3, y3,null);
            v4 = 0;
        }

        Paint score = new Paint();
        score.setColor(Color.BLUE);
        score.setTextSize(40);
        canvas.drawText(String.valueOf(iscore), 10,50,score);

    }
}

class GameObject{

    MyView mv;
    Music m;
    String Songtype;
    GameObject(MyView mv1, String type, final Music a) throws InterruptedException {
        Log.d("Hello","Object");
        mv = mv1;
        m = a;
        Songtype = type;
    }

    public void run(){
        switch(Songtype){
            case "1":
                gogo();
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                bad();
                break;
        }
    }

    public void drop(final MyView mv, Handler handler, String Nodetype, final int start, final int speed) throws InterruptedException {

        switch(Nodetype){
            case "1":
                mv.x = 300; mv.y = 50;
                for (int i = 0; i < 165; i++) {
                    final int thisi = i;
                    final float thisx = mv.x;
                    final float thisy = mv.y;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("Hello",String.format("postDelayed %d %d %d %.0f %.0f:", thisi, start, speed, mv.x, mv.y));
                            mv.v1 = 1;
                            mv.x = thisx;
                            mv.y = thisy + (float) 5 * thisi;
                            Log.d("Hello",String.format("check_in_run %d %d %d %d:", mv.v1, mv.v2, mv.v3, mv.v4));
                            mv.invalidate();
                        }
                    }, start + i * speed);
                }
                break;
            case "2":
                mv.x1 = 630; mv.y1 = 50;
                for (int i = 0; i < 165; i++) {
                    final int thisi = i;
                    final float thisx = mv.x1;
                    final float thisy = mv.y1;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("Hello",String.format("postDelayed %d %d %d %.0f %.0f:", thisi, start, speed, mv.x1, mv.y1));
                            mv.v2 = 1;
                            mv.x1 = thisx;
                            mv.y1 = thisy + (float) 5 * thisi;
                            mv.invalidate();
                        }
                    }, start + i * speed);
                }
                break;
            case "3":
                mv.x2 = 950; mv.y2 = 50;
                for (int i = 0; i < 165; i++) {
                    final int thisi = i;
                    final float thisx = mv.x2;
                    final float thisy = mv.y2;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("Hello",String.format("postDelayed %d %d %d %.0f %.0f:", thisi, start, speed, mv.x2, mv.y2));
                            mv.v3 = 1;
                            mv.x2 = thisx;
                            mv.y2 = thisy + (float) 5 * thisi;
                            mv.invalidate();
                        }
                    }, start + i * speed);
                }
                break;
            case "4":
                mv.x3 = 1270; mv.y3 = 50;
                for (int i = 0; i < 165; i++) {
                    final int thisi = i;
                    final float thisx = mv.x3;
                    final float thisy = mv.y3;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("Hello",String.format("postDelayed %d %d %d %.0f %.0f:", thisi, start, speed, mv.x3, mv.y3));
                            mv.v4 = 1;
                            mv.x3 = thisx;
                            mv.y3 = thisy + (float) 5 * thisi;
                            mv.invalidate();
                        }
                    }, start + i * speed);
                }
                break;
        }

        //final Handler handler = new Handler();


        //handler.removeMessages(0);

        /*handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 2000);*/
    }

    public void CheckNode(MyView mv, float x, float y){ //터치 이벤트시 발생하는 코드 ; 터치할때의 mv위치 와 터치한 부분 비교 ; float x, float y 는 터치이벤트 위치 반환 값

        float x1 = x - 200, x2 = x + 200, y1 = y - 150, y2 = y+150;

        if(mv.v1 == 1){
            if( mv.x >= x1 && mv.x <= x2 && mv.y >= y1 && mv.y <= y2)
                mv.iscore += 10;
            else mv.iscore -= 1;
        }
        if(mv.v2 == 1){
            if( mv.x1 >= x1 && mv.x1 <= x2 && mv.y1 >= y1 && mv.y1 <= y2)
                mv.iscore += 10;
            else mv.iscore -= 1;
        }
        if(mv.v3 == 1){
            if( mv.x2 >= x1 && mv.x2 <= x2 && mv.y2 >= y1 && mv.y2 <= y2)
                mv.iscore += 10;
            else mv.iscore -= 1;
        }
        if(mv.v4 == 1){
            if( mv.x3 >= x1 && mv.x3 <= x2 && mv.y3 >= y1 && mv.y3 <= y2)
                mv.iscore += 10;
            else mv.iscore -= 1;
        }

    }


    public void gogo(){
        try {
            final Handler handler = new Handler();
            drop(mv, handler, "2", 800, 200);
            drop(mv, handler, "3", 1200, 200);
            drop(mv, handler, "1", 1900, 200);
            drop(mv, handler, "4", 2700, 200);
            drop(mv, handler, "2", 3200, 200);
            drop(mv, handler, "4", 3900, 200);

            drop(mv, handler, "1", 5700, 200);
            drop(mv, handler, "2", 6100, 200);
            drop(mv, handler, "3", 6800, 200);
            drop(mv, handler, "4", 7400, 200);
            drop(mv, handler, "1", 8100, 200);
            drop(mv, handler, "4", 8700, 200);

            drop(mv, handler, "1", 10600, 100);
            drop(mv, handler, "3", 10900, 100);
            drop(mv, handler, "2", 11100, 100);

            drop(mv, handler, "2", 11900, 100);
            drop(mv, handler, "4", 12200, 100);
            drop(mv, handler, "3", 12500, 100);

            drop(mv, handler, "1", 13100, 200);
            drop(mv, handler, "2", 13700, 200);
            drop(mv, handler, "3", 14500, 200);

            drop(mv, handler, "1", 15600, 100);
            drop(mv, handler, "3", 15900, 100);
            drop(mv, handler, "2", 16200, 100);

            drop(mv, handler, "2", 16700, 33);
            drop(mv, handler, "4", 17000, 33);
            drop(mv, handler, "3", 17300, 33);

            drop(mv, handler, "1", 18100, 100);
            drop(mv, handler, "3", 18700, 100);
            drop(mv, handler, "2", 19200, 100);

            drop(mv, handler, "1", 20500, 100);
            drop(mv, handler, "4", 21000, 90);
            drop(mv, handler, "3", 21400, 33);
            drop(mv, handler, "2", 21560, 33);

            drop(mv, handler, "3", 22100, 90);
            drop(mv, handler, "2", 22500, 33);
            drop(mv, handler, "1", 22700, 33);

            drop(mv, handler, "4", 23400, 40);
            drop(mv, handler, "2", 23900, 40);

            drop(mv, handler, "1", 24400, 50);
            drop(mv, handler, "4", 24800, 30);
            drop(mv, handler, "2", 25100, 20);

            drop(mv, handler, "2", 25800, 40);
            drop(mv, handler, "2", 26000, 40);
            drop(mv, handler, "3", 26400, 40);
            drop(mv, handler, "3", 26700, 40);
            drop(mv, handler, "2", 27000, 40);
            drop(mv, handler, "3", 27300, 40);

            drop(mv, handler, "4", 28000, 50);
            drop(mv, handler, "1", 28400, 50);
            drop(mv, handler, "3", 28750, 50);

            drop(mv, handler, "2", 29230, 30);
            drop(mv, handler, "3", 29800, 30);

            drop(mv, handler, "3", 30000, 30);
            drop(mv, handler, "2", 30800, 30);
            drop(mv, handler, "3", 31000, 30);

            drop(mv, handler, "1", 31600, 30);
            drop(mv, handler, "4", 31900, 30);
            drop(mv, handler, "1", 32200, 30);

            drop(mv, handler, "2", 33000, 60);
            drop(mv, handler, "4", 33500, 60);
            drop(mv, handler, "3", 34000, 60);
            drop(mv, handler, "4", 34700, 20);
            drop(mv, handler, "2", 34870, 20);

            drop(mv, handler, "4", 35300, 40);
            drop(mv, handler, "2", 35600, 30);
            drop(mv, handler, "4", 36000, 30);

            drop(mv, handler, "3", 36500, 40);
            drop(mv, handler, "1", 37000, 30);
            drop(mv, handler, "3", 37200, 30);

            drop(mv, handler, "1", 37500, 30);
            drop(mv, handler, "2", 37900, 30);
            drop(mv, handler, "3", 38300, 30);
            drop(mv, handler, "4", 38700, 30);
            drop(mv, handler, "2", 39000, 30);
            drop(mv, handler, "3", 39400, 30);
            drop(mv, handler, "1", 39800, 30);
            drop(mv, handler, "3", 40200, 30);
            drop(mv, handler, "2", 40900, 30);

            drop(mv, handler, "4", 40100, 30); //이츠오케이
            drop(mv, handler, "1", 40600, 30);
            drop(mv, handler, "4", 40700, 30);
            drop(mv, handler, "2", 41000, 30);
            drop(mv, handler, "3", 41500, 30);
            drop(mv, handler, "1", 42000, 30);
            drop(mv, handler, "2", 42400, 30);

            drop(mv, handler, "1", 43000, 30); //괜찮지
            drop(mv, handler, "4", 43700, 30); //않아도
            drop(mv, handler, "2", 44400, 30);
            drop(mv, handler, "3", 44700, 30);
            drop(mv, handler, "2", 44900, 30);

            drop(mv, handler, "1", 45500, 30); //뻔
            drop(mv, handler, "1", 45900, 30); //뻔
            drop(mv, handler, "3", 46100, 30); //하
            drop(mv, handler, "3", 46500, 30); //게
            drop(mv, handler, "1", 46800, 30); //즐
            drop(mv, handler, "3", 47000, 30); //겨

            drop(mv, handler, "4", 47600, 30);
            drop(mv, handler, "3", 48200, 30);
            drop(mv, handler, "2", 48500, 30);

            drop(mv, handler, "1", 48900, 30); //고고
            drop(mv, handler, "4", 49500, 30); //베베

            drop(mv, handler, "2", 50000, 30);
            drop(mv, handler, "4", 50700, 30);
            drop(mv, handler, "2", 51000, 30);
            drop(mv, handler, "3", 51300, 30);

            drop(mv, handler, "1", 52600, 30);
            drop(mv, handler, "3", 53200, 30);
            drop(mv, handler, "1", 53500, 30);
            drop(mv, handler, "3", 53900, 30);

            drop(mv, handler, "2", 55200, 30); //너와나의
            drop(mv, handler, "3", 55800, 30); //믹스
            drop(mv, handler, "2", 56000, 30); //앤
            drop(mv, handler, "3", 56300, 30); //매치

            drop(mv, handler, "1", 57500, 30); //빼지말고
            drop(mv, handler, "4", 58200, 30);
            drop(mv, handler, "2", 58500, 30);

            drop(mv, handler, "4", 58800, 30); //고고
            drop(mv, handler, "2", 59400, 30); //베베

            drop(mv, handler, "4", 60000, 30); //뻔
            drop(mv, handler, "3", 60500, 30); //뻔
            drop(mv, handler, "2", 61000, 30);
            drop(mv, handler, "1", 61500, 30);
            drop(mv, handler, "3", 61900, 30); //놀
            drop(mv, handler, "2", 62200, 30); //아

            drop(mv, handler, "4", 62400, 30); //미
            drop(mv, handler, "3", 62900, 30); //친
            drop(mv, handler, "2", 63400, 30); //듯
            drop(mv, handler, "1", 63900, 30); //이
            drop(mv, handler, "3", 64300, 30); //즐
            drop(mv, handler, "2", 64700, 30); //겨

            drop(mv, handler, "3", 65000, 30); //필요없어
            drop(mv, handler, "1", 65600, 30);
            drop(mv, handler, "3", 65900, 30);
            drop(mv, handler, "1", 66200, 30);

            drop(mv, handler, "2", 67500, 30);
            drop(mv, handler, "3", 68000, 30);

            drop(mv, handler, "4", 68700, 30); //고고
            drop(mv, handler, "2", 69300, 30); //베베

            drop(mv, handler, "1", 70000, 100);
            drop(mv, handler, "2", 70500, 30);
            drop(mv, handler, "3", 71100, 30);
            drop(mv, handler, "4", 71700, 30);
            drop(mv, handler, "4", 72300, 30);
            drop(mv, handler, "2", 73000, 30);

            drop(mv, handler, "1", 75000, 30);
            drop(mv, handler, "2", 75500, 30);
            drop(mv, handler, "3", 76100, 30);
            drop(mv, handler, "4", 76700, 30);
            drop(mv, handler, "4", 77300, 30);
            drop(mv, handler, "2", 77800, 30);

            drop(mv, handler, "2", 78500, 30); //고고
            drop(mv, handler, "4", 79100, 30); //베베

            drop(mv, handler, "1", 79900, 30);
            drop(mv, handler, "2", 80200, 30);
            drop(mv, handler, "3", 80700, 30);
            drop(mv, handler, "4", 81200, 30);

            drop(mv, handler, "2", 82200, 100); //또 랩 -포커포커
            drop(mv, handler, "3", 83000, 100);
            drop(mv, handler, "2", 83500, 100);
            drop(mv, handler, "4", 84000, 100); //피사체

            drop(mv, handler, "1", 84800, 100);
            drop(mv, handler, "3", 85400, 100);
            drop(mv, handler, "2", 86000, 100);
            drop(mv, handler, "3", 86600, 100);

            drop(mv, handler, "2", 87400, 100); //이렇다
            drop(mv, handler, "3", 88000, 100); //저렇다
            drop(mv, handler, "2", 88600, 100);
            drop(mv, handler, "4", 89000, 100);
            drop(mv, handler, "2", 89600, 100);
            drop(mv, handler, "3", 90200, 100);
            drop(mv, handler, "1", 90800, 100);
            drop(mv, handler, "3", 91400, 100);

            drop(mv, handler, "2", 92200, 300); //오
            drop(mv, handler, "3", 92500, 300); //케이
            drop(mv, handler, "1", 93100, 300); //투
            drop(mv, handler, "3", 93400, 300); //나
            drop(mv, handler, "2", 94000, 300); //비
            drop(mv, handler, "4", 94400, 300); //파인

            drop(mv, handler, "1", 95100, 200); //괜찮지
            drop(mv, handler, "3", 95500, 200); //않아도
            drop(mv, handler, "2", 96200, 100); //괜
            drop(mv, handler, "4", 96500, 100); //찮
            drop(mv, handler, "2", 96800, 100); //아

            drop(mv, handler, "1", 97300, 100); //뻔
            drop(mv, handler, "1", 97700, 100); //뻔
            drop(mv, handler, "3", 98100, 100); //하
            drop(mv, handler, "3", 98500, 100); //게
            drop(mv, handler, "1", 98900, 100); //즐
            drop(mv, handler, "3", 99300, 100); //겨

            drop(mv, handler, "4", 99600, 100);
            drop(mv, handler, "3", 100000, 100);
            drop(mv, handler, "2", 200400, 100);

            drop(mv, handler, "1", 100800, 80); //고고
            drop(mv, handler, "4", 101200, 100); //베베

            drop(mv, handler, "2", 102100, 100);
            drop(mv, handler, "4", 102700, 80);
            drop(mv, handler, "2", 103000, 80);
            drop(mv, handler, "3", 103300, 80);

            drop(mv, handler, "1", 104600, 100); //드레스코드는
            drop(mv, handler, "3", 105200, 80); //블링
            drop(mv, handler, "1", 105500, 80);
            drop(mv, handler, "3", 105800, 80);

            drop(mv, handler, "2", 107000, 100); //너와나의
            drop(mv, handler, "3", 107600, 80); //믹스
            drop(mv, handler, "2", 107900, 80); //앤
            drop(mv, handler, "3", 108200, 80); //매치

            drop(mv, handler, "1", 109500, 100); //빼지말고
            drop(mv, handler, "4", 110100, 80);
            drop(mv, handler, "2", 110400, 80);

            drop(mv, handler, "4", 110700, 70); //고고
            drop(mv, handler, "2", 111300, 70); //베베

            drop(mv, handler, "4", 112000, 100); //뻔
            drop(mv, handler, "3", 112500, 100); //뻔
            drop(mv, handler, "2", 113000, 100);
            drop(mv, handler, "1", 113500, 100);
            drop(mv, handler, "3", 114900, 80); //놀
            drop(mv, handler, "2", 114100, 70); //아

            drop(mv, handler, "4", 114500, 100); //미
            drop(mv, handler, "3", 115000, 100); //친
            drop(mv, handler, "2", 115500, 100); //듯
            drop(mv, handler, "1", 116000, 100); //이
            drop(mv, handler, "3", 116300, 80); //즐
            drop(mv, handler, "2", 116600, 70); //겨

            drop(mv, handler, "3", 116900, 100); //필요없어
            drop(mv, handler, "1", 117500, 70);
            drop(mv, handler, "3", 117900, 70);
            drop(mv, handler, "1", 118200, 70);

            drop(mv, handler, "2", 119400, 100);
            drop(mv, handler, "3", 120000, 100);

            drop(mv, handler, "4", 120700, 200); //고고
            drop(mv, handler, "2", 121200, 200); //베베

            drop(mv, handler, "1", 121900, 200);
            drop(mv, handler, "2", 122500, 200);
            drop(mv, handler, "3", 123100, 200);
            drop(mv, handler, "4", 123700, 200);
            drop(mv, handler, "4", 124300, 200);
            drop(mv, handler, "2", 124900, 200);

            drop(mv, handler, "1", 126900, 200);
            drop(mv, handler, "2", 127500, 200);
            drop(mv, handler, "3", 128100, 200);
            drop(mv, handler, "4", 128700, 200);
            drop(mv, handler, "4", 129300, 200);
            drop(mv, handler, "2", 129900, 200);

            drop(mv, handler, "2", 130500, 200); //고고
            drop(mv, handler, "4", 131200, 200); //베베

            drop(mv, handler, "1", 131900, 300);
            drop(mv, handler, "3", 133000, 300);
            drop(mv, handler, "2", 134300, 300);
            drop(mv, handler, "4", 135500, 100);
            drop(mv, handler, "2", 136100, 100);

            drop(mv, handler, "1", 136800, 300);
            drop(mv, handler, "3", 137900, 300);
            drop(mv, handler, "2", 139200, 300);
            drop(mv, handler, "4", 140400, 100); //고고
            drop(mv, handler, "2", 141100, 100); //베베

            drop(mv, handler, "2", 141700, 100);
            drop(mv, handler, "3", 142300, 100);
            drop(mv, handler, "1", 142900, 100);
            drop(mv, handler, "3", 143500, 100);
            drop(mv, handler, "2", 144100, 100);
            drop(mv, handler, "4", 144600, 100);
            drop(mv, handler, "1", 145400, 100);

            drop(mv, handler, "2", 146600, 100);
            drop(mv, handler, "3", 148200, 100);
            drop(mv, handler, "1", 147800, 100);
            drop(mv, handler, "3", 148600, 100);

            drop(mv, handler, "1", 149100, 200); //난리가
            drop(mv, handler, "2", 149700, 200); //나
            drop(mv, handler, "3", 150400, 200); //난리가
            drop(mv, handler, "4", 151000, 200); //나

            drop(mv, handler, "2", 151500, 100);
            drop(mv, handler, "3", 152000, 100);
            drop(mv, handler, "2", 152500, 100);

            drop(mv, handler, "4", 152800, 100); //고고
            drop(mv, handler, "2", 153400, 100); //베베

            drop(mv, handler, "2", 154000, 100);
            drop(mv, handler, "4", 154700, 80);
            drop(mv, handler, "2", 155000, 80);
            drop(mv, handler, "3", 155300, 80);

            drop(mv, handler, "1", 156500, 100); //드레스코드는
            drop(mv, handler, "3", 157100, 80); //블링
            drop(mv, handler, "1", 157400, 80);
            drop(mv, handler, "3", 157700, 80);

            drop(mv, handler, "2", 159100, 100); //너와나의
            drop(mv, handler, "3", 159600, 80); //믹스
            drop(mv, handler, "2", 159900, 80); //앤
            drop(mv, handler, "3", 160200, 80); //매치

            drop(mv, handler, "1", 161400, 100); //빼지말고
            drop(mv, handler, "4", 162000, 80);
            drop(mv, handler, "2", 162400, 80);

            drop(mv, handler, "4", 162700, 70); //고고
            drop(mv, handler, "2", 163200, 70); //베베

            drop(mv, handler, "4", 163900, 100); //뻔
            drop(mv, handler, "3", 164400, 100); //뻔
            drop(mv, handler, "2", 164900, 100);
            drop(mv, handler, "1", 165400, 100);
            drop(mv, handler, "3", 165700, 80); //놀
            drop(mv, handler, "2", 165000, 70); //아

            drop(mv, handler, "4", 166400, 100); //미
            drop(mv, handler, "3", 166900, 100); //친
            drop(mv, handler, "2", 167400, 100); //듯
            drop(mv, handler, "1", 167900, 100); //이
            drop(mv, handler, "3", 168200, 80); //즐
            drop(mv, handler, "2", 168500, 70); //겨

            drop(mv, handler, "3", 168900, 100); //필요없어
            drop(mv, handler, "1", 169500, 70);
            drop(mv, handler, "3", 169800, 70);
            drop(mv, handler, "1", 170100, 70);

            drop(mv, handler, "2", 171400, 100);
            drop(mv, handler, "3", 171900, 100);

            drop(mv, handler, "4", 172600, 200); //고고
            drop(mv, handler, "2", 173100, 200); //베베

            drop(mv, handler, "1", 173800, 200);
            drop(mv, handler, "2", 174400, 200);
            drop(mv, handler, "3", 175000, 200);
            drop(mv, handler, "4", 175700, 200);
            drop(mv, handler, "4", 176200, 200);
            drop(mv, handler, "2", 176900, 200);

            drop(mv, handler, "1", 178800, 200);
            drop(mv, handler, "2", 179400, 200);
            drop(mv, handler, "3", 180100, 200);
            drop(mv, handler, "4", 180700, 200);
            drop(mv, handler, "4", 181300, 200);
            drop(mv, handler, "2", 181800, 200);

            drop(mv, handler, "2", 182500, 200); //고고
            drop(mv, handler, "4", 183200, 200); //베베


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
        }, 300000);

    }

    public void bad(){
        try {
            final Handler handler = new Handler();
            drop(mv,  handler,"1", 0, 10);
            drop(mv,  handler,"3", 1875, 10);
            drop(mv,  handler,"1", 1875, 10); // +750
            drop(mv,  handler,"4", 2625, 10);
            drop(mv,  handler,"2", 3750, 10);
            drop(mv,  handler,"4", 5625, 10);
            drop(mv,  handler,"2", 5625, 10);// +750
            drop(mv,  handler,"3", 6375, 10);
            drop(mv,  handler,"2", 7500, 10);
            drop(mv,  handler,"4", 9375, 10);
            drop(mv,  handler,"2", 9375, 10);
            drop(mv,  handler,"1", 10125, 10);
            drop(mv,  handler,"4", 10875, 10);
            drop(mv,  handler,"3", 11625, 10);
            drop(mv,  handler,"2", 11250, 10);
            drop(mv,  handler,"4", 13125, 10);
            drop(mv,  handler,"2", 13125, 10); //*
            drop(mv,  handler,"2", 15000, 10);
            drop(mv,  handler,"4", 16875, 10);
            drop(mv,  handler,"1", 18750, 10);
            drop(mv,  handler,"3", 20625, 10);
            drop(mv,  handler,"1", 22500, 10);
            drop(mv,  handler,"3", 24375, 10);
            drop(mv,  handler,"1", 26250, 10);
            drop(mv,  handler,"3", 28125, 10);
            drop(mv,  handler,"2", 30000, 10);
            drop(mv,  handler,"2", 32000, 10);
            drop(mv,  handler,"2", 34000, 10);
            drop(mv,  handler,"3", 36000, 10);
            drop(mv,  handler,"3", 38000, 10);
            drop(mv,  handler,"3", 40000, 10);
            drop(mv,  handler,"4", 41750, 10);
            drop(mv,  handler,"3", 43500, 10);
            drop(mv,  handler,"2", 45250, 10);
            drop(mv,  handler,"1", 47000, 10);
            drop(mv,  handler,"1", 48750, 10);
            drop(mv,  handler,"2", 50500, 10);
            drop(mv,  handler,"4", 52250, 10);
            drop(mv,  handler,"3", 54000, 10);
            drop(mv,  handler,"2", 55750, 10);
            drop(mv,  handler,"1", 58000, 10);
            drop(mv,  handler,"2", 61500, 10);
            drop(mv,  handler,"4", 63250, 10);
            drop(mv,  handler,"1", 65000, 10);
            drop(mv,  handler,"3", 66750, 10);
            drop(mv,  handler,"1", 68500, 10);
            drop(mv,  handler,"4", 70250, 10);
            drop(mv,  handler,"1", 72000, 10);
            drop(mv,  handler,"2", 73750, 10);
            drop(mv,  handler,"2", 75500, 10);
            drop(mv,  handler,"1", 77500, 10);
            drop(mv,  handler,"1", 79500, 10);
            drop(mv,  handler,"1", 81500, 10);
            drop(mv,  handler,"2", 83500, 10);
            drop(mv,  handler,"2", 85500, 10);
            drop(mv,  handler,"2", 87500, 10);
            drop(mv,  handler,"4", 89250, 10);
            drop(mv,  handler,"1", 91000, 10); //  repeat 1750
            drop(mv,  handler,"3", 92750, 10);
            drop(mv,  handler,"1", 94500, 10);
            drop(mv,  handler,"2", 96250, 10);
            drop(mv,  handler,"1", 98000, 10);
            drop(mv,  handler,"3", 101500, 10);
            drop(mv,  handler,"1", 103250, 10);
            drop(mv,  handler,"4", 105000, 10);
            drop(mv,  handler,"3", 106750, 10);
            drop(mv,  handler,"2", 108500, 10);
            drop(mv,  handler,"1", 110250, 10);
            drop(mv,  handler,"2", 112000, 10);
            drop(mv,  handler,"4", 113750, 10);
            drop(mv,  handler,"3", 115500, 10);
            drop(mv,  handler,"1", 117250, 10);
            drop(mv,  handler,"2", 119000, 10);
            drop(mv,  handler,"3", 120750, 10);
            drop(mv,  handler,"4", 122500, 10);
            drop(mv,  handler,"3", 124250, 10);
            drop(mv,  handler,"1", 126000, 10);
            drop(mv,  handler,"2", 127750, 10);
            drop(mv,  handler,"4", 129500, 10);
            drop(mv,  handler,"4", 131250, 10);
            drop(mv,  handler,"3", 133000, 10);
            drop(mv,  handler,"1", 134750, 10);
            drop(mv,  handler,"3", 136500, 10);
            drop(mv,  handler,"4", 138250, 10);
            drop(mv,  handler,"3", 140000, 10);
            drop(mv,  handler,"2", 141750, 10);
            drop(mv,  handler,"1", 143500, 10);
            drop(mv,  handler,"3", 145250, 10); // slow down
            drop(mv,  handler,"3", 150500, 10);
            drop(mv,  handler,"3", 154000, 10);
            drop(mv,  handler,"1", 157500, 10);
            drop(mv,  handler,"1", 161000, 10);
            drop(mv,  handler,"1", 164500, 10);
            drop(mv,  handler,"2", 168000, 10);
            drop(mv,  handler,"4", 171500, 10); // 2:50 (170)->stop
            drop(mv,  handler,"3", 175500, 10);
            drop(mv,  handler,"3", 177500, 10);
            drop(mv,  handler,"3", 179500, 10);
            drop(mv,  handler,"3", 181375, 10);
            drop(mv,  handler,"3", 183250, 10);
            drop(mv,  handler,"3", 185125, 10);
            drop(mv,  handler,"3", 187000, 10);

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
        }, 300000);
    }
}


public class Game extends Activity {

    GameObject gameobject;

    protected void onCreate(Bundle savedInstanceState) {
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //TextView tvTitle = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        //tvTitle.setText(intent.getStringExtra("title"));

        String m = intent.getStringExtra("title");
        // Intent i = new Intent(getApplicationContext(), Node.class);

        final MyView mv;
        setContentView(R.layout.activity_game);
        mv = (MyView) findViewById(basicnode);
        LinearLayout ll = (LinearLayout)findViewById(R.id.basic);

        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        float x = event.getX();
                        float y = event.getY();
                        gameobject.CheckNode(mv, x, y);
                        mv.invalidate();
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });

        switch (m) {
            case "고고베베 - 마마무":
                Music a1 = new Music(this, "gogobebe", false);
                mv.invalidate();
                try {
                    gameobject = new GameObject(mv, "1", a1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //GameObject를 만들고 그 안에서 노래를 스탑시키고 나옴
                break;
            case "답을 찾지 못한 날 - 윤하":
                Music a2 = new Music(this, "nodab", false);
                mv.invalidate();
                try {
                    gameobject = new GameObject(mv, "2", a2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "STAY - BlackPink":
                Music a3 = new Music(this, "stay", false);
                mv.invalidate();
                try {
                    gameobject = new GameObject(mv, "3", a3);
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
                    gameobject = new GameObject(mv, "5", a5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Hello","Start");
        gameobject.run();
    }

}