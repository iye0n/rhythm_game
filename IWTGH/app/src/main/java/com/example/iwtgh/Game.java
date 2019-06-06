package com.example.iwtgh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import static com.example.iwtgh.R.id.basicnode;

//class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {
//    @Override
//    protected Void doInBackground(Integer... integers) {
//
//        return null;
//    }
//
//    @Override
//    protected void onPreExecute(){
//        super.onPreExecute();
//    }
//
//    @Override
//    protected void onProgressUpdate(Integer...params){
//
//    }
//    @Override
//    protected void onPostExecute(Void result){
//            super.onPostExecute(result);
//    }
//}

class MyView extends View {

    float x = 0, y = 0;
    float x1 = 0, y1 = 0;
    float x2 = 0, y2 = 0;
    float x3 = 0, y3 = 0;
    int v1 = 0, v2 = 0, v3 = 0, v4 = 0;
    public static int iscore = 0;


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
        score.setTextSize(70);
        canvas.drawText("Score:"+String.valueOf(iscore), 8,70,score);

        Paint direction = new Paint();
        direction.setARGB(80,150,120,240);
        direction.setStrokeWidth(10);
        canvas.drawRect(265,880,1530,1200,direction);

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
                for (int i = 0; i < 171; i++) {
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
                for (int i = 0; i < 171; i++) {
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
                for (int i = 0; i < 171; i++) {
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
                for (int i = 0; i < 171; i++) {
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
        //265,900,1530,1200
        if(y1<=880) mv.iscore -=0;

        else {
            if (mv.v1 == 1) {
                if (mv.x >= x1 && mv.x <= x2 && mv.y >= y1 && mv.y <= y2)
                    mv.iscore += 10;
                else mv.iscore -= 1;
            }
            if (mv.v2 == 1) {
                if (mv.x1 >= x1 && mv.x1 <= x2 && mv.y1 >= y1 && mv.y1 <= y2)
                    mv.iscore += 10;
                else mv.iscore -= 1;
            }
            if (mv.v3 == 1) {
                if (mv.x2 >= x1 && mv.x2 <= x2 && mv.y2 >= y1 && mv.y2 <= y2)
                    mv.iscore += 10;
                else mv.iscore -= 1;
            }
            if (mv.v4 == 1) {
                if (mv.x3 >= x1 && mv.x3 <= x2 && mv.y3 >= y1 && mv.y3 <= y2)
                    mv.iscore += 10;
                else mv.iscore -= 1;
            }
        }

    }


    public void gogo(){
        try {
            final Handler handler = new Handler();

            drop(mv, handler, "2", 200, 10);
            drop(mv, handler, "3", 1200, 10);
            drop(mv, handler, "1", 1900, 10);
            drop(mv, handler, "4", 2700, 10);
            drop(mv, handler, "2", 3200, 10);
            drop(mv, handler, "3", 3900, 10);

            drop(mv, handler, "2", 5700, 10);
            drop(mv, handler, "3", 6100, 10);
            drop(mv, handler, "1", 6800, 10);
            drop(mv, handler, "4", 7400, 10);
            drop(mv, handler, "2", 8100, 10);
            drop(mv, handler, "3", 8700, 10);

            drop(mv, handler, "1", 10600, 10); //폰은
            drop(mv, handler, "4", 10900, 10);
            drop(mv, handler, "3", 11100, 10);

            drop(mv, handler, "2", 11900, 10); //끼는
            drop(mv, handler, "4", 12200, 10);
            drop(mv, handler, "1", 12500, 10);

            drop(mv, handler, "3", 13100, 10); //골치 아픈
            drop(mv, handler, "2", 13700, 10);
            drop(mv, handler, "4", 14500, 10);

            drop(mv, handler, "3", 15600, 10);
            drop(mv, handler, "2", 15900, 10);
            drop(mv, handler, "4", 16200, 10);

            drop(mv, handler, "1", 16700, 10); //상처를
            drop(mv, handler, "3", 17000, 10);
            drop(mv, handler, "2", 17300, 10);

            drop(mv, handler, "4", 18100, 10); //착한척은
            drop(mv, handler, "1", 18700, 10);
            drop(mv, handler, "3", 19200, 10);

            drop(mv, handler, "2", 20500, 10); //뻠

            drop(mv, handler, "4", 21000, 10);
            drop(mv, handler, "1", 21560, 10);

            drop(mv, handler, "2", 22100, 10);
            drop(mv, handler, "3", 22700, 10);

            drop(mv, handler, "4", 23400, 10); //리듬에
            drop(mv, handler, "2", 23900, 10);

            drop(mv, handler, "3", 24400, 10); //몸을 맡겨
            drop(mv, handler, "1", 24800, 10);

            drop(mv, handler, "2", 25800, 10); //뻔뻔
            drop(mv, handler, "3", 26400, 10); //하게
            drop(mv, handler, "1", 27000, 10); //놀
            drop(mv, handler, "4", 27300, 10); //아

            drop(mv, handler, "2", 28000, 10);
            drop(mv, handler, "3", 28400, 10);
            drop(mv, handler, "1", 28750, 10);

            drop(mv, handler, "4", 30000, 10); //하루아침에
            drop(mv, handler, "2", 30800, 10);
            drop(mv, handler, "3", 31000, 10);

            drop(mv, handler, "1", 31600, 10);
            drop(mv, handler, "4", 31900, 10);

            drop(mv, handler, "2", 33000, 10); //별거 아닌
            drop(mv, handler, "3", 33500, 10);
            drop(mv, handler, "4", 34000, 10);
            drop(mv, handler, "1", 34700, 10);
            drop(mv, handler, "2", 34870, 10);

            drop(mv, handler, "3", 35300, 10); //그래 난
            drop(mv, handler, "4", 36000, 10);

            drop(mv, handler, "1", 36500, 10);
            drop(mv, handler, "2", 37000, 10);
            drop(mv, handler, "3", 37200, 10);

            drop(mv, handler, "4", 37500, 10); //랩 샹ㅅㅂ
            drop(mv, handler, "1", 38700, 10);
            drop(mv, handler, "3", 39800, 10);
            drop(mv, handler, "2", 40900, 10);

            drop(mv, handler, "4", 40100, 10); //이츠오케이
            drop(mv, handler, "1", 41000, 10);
            drop(mv, handler, "2", 42000, 10);

            drop(mv, handler, "1", 43000, 10); //괜찮지
            drop(mv, handler, "4", 43700, 10); //않아도
            drop(mv, handler, "2", 44400, 10); //괜
            drop(mv, handler, "3", 44900, 10);

            drop(mv, handler, "1", 45500, 10); //뻔뻔
            drop(mv, handler, "4", 46100, 10); //하게
            drop(mv, handler, "2", 46800, 10); //즐
            drop(mv, handler, "3", 47000, 10); //겨

            drop(mv, handler, "1", 47600, 10);
            drop(mv, handler, "4", 48500, 10);

            drop(mv, handler, "2", 48900, 10); //고고
            drop(mv, handler, "3", 49500, 10); //베베

            drop(mv, handler, "1", 50000, 10);
            drop(mv, handler, "2", 50700, 10);
            drop(mv, handler, "3", 51300, 10);

            drop(mv, handler, "1", 52600, 10); //드레스 코드는
            drop(mv, handler, "4", 53200, 10);
            drop(mv, handler, "3", 53900, 10);

            drop(mv, handler, "2", 55200, 10); //너와나의
            drop(mv, handler, "3", 55800, 10); //믹스
            drop(mv, handler, "1", 56300, 10); //매치

            drop(mv, handler, "4", 57500, 10); //빼지말고
            drop(mv, handler, "2", 58200, 10);

            drop(mv, handler, "3", 58800, 10); //고고
            drop(mv, handler, "1", 59400, 10); //베베

            drop(mv, handler, "2", 60000, 10); //뻔뻔
            drop(mv, handler, "3", 61000, 10); //하게
            drop(mv, handler, "1", 61900, 10); //놀
            drop(mv, handler, "4", 62200, 10); //아

            drop(mv, handler, "2", 62400, 10); //미친
            drop(mv, handler, "3", 63400, 10); //듯이
            drop(mv, handler, "1", 64300, 10); //즐
            drop(mv, handler, "4", 64700, 10); //겨

            drop(mv, handler, "2", 65000, 30); //필요없어
            drop(mv, handler, "3", 65600, 30);
            drop(mv, handler, "1", 66200, 30);

            drop(mv, handler, "2", 67500, 10);
            drop(mv, handler, "3", 68000, 10);

            drop(mv, handler, "4", 68700, 10); //고고
            drop(mv, handler, "1", 69300, 10); //베베

            drop(mv, handler, "2", 70000, 10);
            drop(mv, handler, "3", 70500, 10);
            drop(mv, handler, "1", 71100, 10);
            drop(mv, handler, "4", 71700, 10);
            drop(mv, handler, "2", 72300, 10);
            drop(mv, handler, "3", 73000, 10);

            drop(mv, handler, "1", 75000, 10);
            drop(mv, handler, "4", 75500, 10);
            drop(mv, handler, "2", 76100, 10);
            drop(mv, handler, "3", 76700, 10);
            drop(mv, handler, "1", 77300, 10);
            drop(mv, handler, "4", 77800, 10);

            drop(mv, handler, "2", 78500, 10); //고고
            drop(mv, handler, "3", 79100, 10); //베베

            drop(mv, handler, "1", 79900, 10);
            drop(mv, handler, "4", 80200, 10);
            drop(mv, handler, "2", 80700, 10);
            drop(mv, handler, "3", 81200, 10);

            drop(mv, handler, "2", 82200, 10); //또 랩 -포커포커
            drop(mv, handler, "3", 83000, 10);
            drop(mv, handler, "1", 83500, 10);
            drop(mv, handler, "4", 84000, 10); //피사체

            drop(mv, handler, "2", 84800, 10);
            drop(mv, handler, "3", 85400, 10);
            drop(mv, handler, "4", 86000, 10);
            drop(mv, handler, "1", 86600, 10);

            drop(mv, handler, "2", 87400, 10); //이렇다
            drop(mv, handler, "3", 88600, 10);
            drop(mv, handler, "2", 89600, 10);
            drop(mv, handler, "3", 90800, 10);

            drop(mv, handler, "2", 92200, 10); //오
            drop(mv, handler, "3", 92500, 10); //케이
            drop(mv, handler, "1", 93100, 10); //투
            drop(mv, handler, "4", 93400, 10); //나
            drop(mv, handler, "2", 94000, 10); //비
            drop(mv, handler, "3", 94400, 10); //파인

            drop(mv, handler, "1", 95100, 10); //괜찮지
            drop(mv, handler, "4", 95500, 10); //않아도
            drop(mv, handler, "2", 96200, 10); //괜
            drop(mv, handler, "3", 96800, 10); //아

            drop(mv, handler, "1", 97300, 10); //뻔뻔
            drop(mv, handler, "4", 98100, 10); //하게
            drop(mv, handler, "1", 98900, 10); //즐
            drop(mv, handler, "3", 99300, 10); //겨

            drop(mv, handler, "2", 99600, 10);
            drop(mv, handler, "4", 100000, 10);

            drop(mv, handler, "1", 100800, 10); //고고
            drop(mv, handler, "3", 101200, 10); //베베

            drop(mv, handler, "2", 102100, 10);
            drop(mv, handler, "4", 102700, 10);
            drop(mv, handler, "3", 103300, 10);

            drop(mv, handler, "1", 104600, 10); //드레스코드는
            drop(mv, handler, "3", 105200, 10); //블링
            drop(mv, handler, "2", 105800, 10);

            drop(mv, handler, "4", 107000, 10); //너와나의
            drop(mv, handler, "1", 107600, 10); //믹스
            drop(mv, handler, "2", 108200, 10); //매치

            drop(mv, handler, "1", 109500, 10); //빼지말고
            drop(mv, handler, "4", 110100, 10);

            drop(mv, handler, "2", 110700, 10); //고고
            drop(mv, handler, "3", 111300, 10); //베베

            drop(mv, handler, "4", 112000, 10); //뻔뻔
            drop(mv, handler, "2", 113000, 10); //하게
            drop(mv, handler, "3", 114900, 10); //놀
            drop(mv, handler, "1", 114100, 10); //아

            drop(mv, handler, "4", 114500, 10); //미친
            drop(mv, handler, "2", 115500, 10); //듯이
            drop(mv, handler, "3", 116300, 10); //즐
            drop(mv, handler, "4", 116600, 10); //겨

            drop(mv, handler, "3", 116900, 10); //필요없어
            drop(mv, handler, "1", 117500, 10);
            drop(mv, handler, "4", 118200, 10);

            drop(mv, handler, "2", 119400, 10);
            drop(mv, handler, "3", 120000, 10);

            drop(mv, handler, "4", 120700, 10); //고고
            drop(mv, handler, "1", 121200, 10); //베베

            drop(mv, handler, "2", 121900, 10);
            drop(mv, handler, "3", 122500, 10);
            drop(mv, handler, "4", 123100, 10);
            drop(mv, handler, "1", 123700, 10);
            drop(mv, handler, "2", 124300, 10);
            drop(mv, handler, "3", 124900, 10);

            drop(mv, handler, "1", 126900, 10);
            drop(mv, handler, "2", 127500, 10);
            drop(mv, handler, "3", 128100, 10);
            drop(mv, handler, "4", 128700, 10);
            drop(mv, handler, "1", 129300, 10);
            drop(mv, handler, "3", 129900, 10);

            drop(mv, handler, "2", 130500, 10); //고고
            drop(mv, handler, "4", 131200, 10); //베베

            drop(mv, handler, "1", 131900, 10);
            drop(mv, handler, "3", 133000, 10);
            drop(mv, handler, "2", 134300, 10);
            drop(mv, handler, "4", 135500, 10);
            drop(mv, handler, "2", 136100, 10);

            drop(mv, handler, "1", 136800, 10);
            drop(mv, handler, "3", 137900, 10);
            drop(mv, handler, "2", 139200, 10);
            drop(mv, handler, "4", 140400, 10); //고고
            drop(mv, handler, "2", 141100, 10); //베베

            drop(mv, handler, "1", 141700, 10);
            drop(mv, handler, "3", 142300, 10);
            drop(mv, handler, "2", 142900, 10);
            drop(mv, handler, "1", 143500, 10);
            drop(mv, handler, "4", 144100, 10);
            drop(mv, handler, "3", 144600, 10);
            drop(mv, handler, "1", 145400, 10);

            drop(mv, handler, "2", 146600, 10);
            drop(mv, handler, "3", 148200, 10);
            drop(mv, handler, "1", 147800, 10);
            drop(mv, handler, "4", 148600, 10);

            drop(mv, handler, "2", 149100, 10); //난리가
            drop(mv, handler, "1", 149700, 10); //나
            drop(mv, handler, "3", 150400, 10); //난리가
            drop(mv, handler, "4", 151000, 10); //나

            drop(mv, handler, "2", 151500, 10);
            drop(mv, handler, "1", 152000, 10);
            drop(mv, handler, "3", 152500, 10);

            drop(mv, handler, "4", 152800, 10); //고고
            drop(mv, handler, "2", 153400, 10); //베베

            drop(mv, handler, "1", 154000, 10);
            drop(mv, handler, "4", 154700, 10);
            drop(mv, handler, "3", 155300, 10);

            drop(mv, handler, "1", 156500, 10); //드레스코드는
            drop(mv, handler, "3", 157100, 10); //블링
            drop(mv, handler, "2", 157700, 10);

            drop(mv, handler, "3", 159100, 10); //너와나의
            drop(mv, handler, "2", 159600, 10); //믹스
            drop(mv, handler, "4", 160200, 10); //매치

            drop(mv, handler, "1", 161400, 10); //빼지말고
            drop(mv, handler, "4", 162000, 10);

            drop(mv, handler, "2", 162700, 10); //고고
            drop(mv, handler, "3", 163200, 10); //베베

            drop(mv, handler, "4", 163900, 10); //뻔뻔
            drop(mv, handler, "2", 164900, 10); //하게
            drop(mv, handler, "3", 165700, 10); //놀
            drop(mv, handler, "1", 165000, 10); //아

            drop(mv, handler, "4", 166400, 10); //미친
            drop(mv, handler, "3", 167400, 10); //듯이
            drop(mv, handler, "1", 168200, 10); //즐
            drop(mv, handler, "2", 168500, 10); //겨

            drop(mv, handler, "4", 168900, 10); //필요없어
            drop(mv, handler, "3", 169500, 10);
            drop(mv, handler, "1", 170100, 10);

            drop(mv, handler, "2", 171400, 10);
            drop(mv, handler, "3", 171900, 10);

            drop(mv, handler, "1", 172600, 10); //고고
            drop(mv, handler, "4", 173100, 10); //베베

            drop(mv, handler, "2", 173800, 10);
            drop(mv, handler, "3", 174400, 10);
            drop(mv, handler, "4", 175000, 10);
            drop(mv, handler, "1", 175700, 10);
            drop(mv, handler, "2", 176200, 10);
            drop(mv, handler, "3", 176900, 10);

            drop(mv, handler, "1", 178800, 10);
            drop(mv, handler, "2", 179400, 10);
            drop(mv, handler, "3", 180100, 10);
            drop(mv, handler, "4", 180700, 10);
            drop(mv, handler, "2", 181300, 10);
            drop(mv, handler, "1", 181800, 10);

            drop(mv, handler, "3", 182500, 10); //고고
            drop(mv, handler, "2", 183200, 10); //베베


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
//
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
            drop(mv,  handler,"2", 13125, 10);
            drop(mv,  handler,"2", 15000, 10);
            drop(mv,  handler,"4", 16875, 10);
            drop(mv,  handler,"3", 16875, 10);
            drop(mv,  handler,"2", 17625, 10);
            drop(mv,  handler,"1", 18750, 10);
            drop(mv,  handler,"3", 20625, 10);
            drop(mv,  handler,"2", 20625, 10);
            drop(mv,  handler,"4", 21375, 10);
            drop(mv,  handler,"1", 22500, 10);
            drop(mv,  handler,"3", 24375, 10);
            drop(mv,  handler,"1", 26250, 10);
            drop(mv,  handler,"3", 28125, 10);
            drop(mv,  handler,"2", 30000, 10);
            drop(mv,  handler,"1", 30000, 10);
            drop(mv,  handler,"4", 30000, 10);
            drop(mv,  handler,"3", 31750, 10);
            drop(mv,  handler,"2", 32000, 10);
            drop(mv,  handler,"1", 33000, 10);
            drop(mv,  handler,"2", 34000, 10);
            drop(mv,  handler,"4", 35000, 10);
            drop(mv,  handler,"3", 36000, 10);
            drop(mv,  handler,"1", 37000, 10);
            drop(mv,  handler,"3", 38000, 10);
            drop(mv,  handler,"2", 39000, 10);
            drop(mv,  handler,"3", 40000, 10);
            drop(mv,  handler,"1", 40000, 10);
            drop(mv,  handler,"4", 41750, 10);
            drop(mv,  handler,"1", 42500, 10);
            drop(mv,  handler,"2", 43250, 10);
            drop(mv,  handler,"3", 43500, 10);
            drop(mv,  handler,"2", 45250, 10);
            drop(mv,  handler,"4", 45850, 10); // + 600
            drop(mv,  handler,"1", 47000, 10);
            drop(mv,  handler,"3", 47750, 10); // + 750
            drop(mv,  handler,"1", 48750, 10);
            drop(mv,  handler,"4", 48750, 10);
            drop(mv,  handler,"2", 49350, 10);
            drop(mv,  handler,"1", 50500, 10);
            drop(mv,  handler,"2", 51250, 10);
            drop(mv,  handler,"4", 52250, 10);
            drop(mv,  handler,"3", 52250, 10);
            drop(mv,  handler,"1", 52850, 10);
            drop(mv,  handler,"3", 54000, 10);
            drop(mv,  handler,"2", 54750, 10);
            drop(mv,  handler,"3", 55750, 10);
            drop(mv,  handler,"4", 55750, 10);
            drop(mv,  handler,"1", 58000, 10);
            drop(mv,  handler,"2", 58600, 10);
            drop(mv,  handler,"3", 61500, 10);
            drop(mv,  handler,"1", 62250, 10);
            drop(mv,  handler,"4", 63250, 10);
            drop(mv,  handler,"1", 65000, 10);
            drop(mv,  handler,"2", 65000, 10);
            drop(mv,  handler,"4", 65600, 10);
            drop(mv,  handler,"3", 66750, 10);
            drop(mv,  handler,"2", 67500, 10);
            drop(mv,  handler,"4", 67500, 10);
            drop(mv,  handler,"1", 68500, 10);
            drop(mv,  handler,"2", 69100, 10);
            drop(mv,  handler,"3", 69100, 10);
            drop(mv,  handler,"4", 70250, 10);
            drop(mv,  handler,"2", 71000, 10);
            drop(mv,  handler,"1", 72000, 10);
            drop(mv,  handler,"3", 72000, 10);
            drop(mv,  handler,"4", 72000, 10);
            drop(mv,  handler,"2", 73750, 10);
            drop(mv,  handler,"4", 73750, 10);
            drop(mv,  handler,"1", 74350, 10);
            drop(mv,  handler,"2", 75500, 10);
            drop(mv,  handler,"3", 75500, 10);
            drop(mv,  handler,"4", 76100, 10);
            drop(mv,  handler,"1", 76850, 10);
            drop(mv,  handler,"3", 77500, 10);
            drop(mv,  handler,"2", 77500, 10);
            drop(mv,  handler,"1", 79500, 10);
            drop(mv,  handler,"4", 79500, 10);
            drop(mv,  handler,"1", 81500, 10);
            drop(mv,  handler,"2", 83500, 10);
            drop(mv,  handler,"1", 83500, 10);
            drop(mv,  handler,"2", 85500, 10);
            drop(mv,  handler,"3", 85500, 10);
            drop(mv,  handler,"2", 87500, 10);
            drop(mv,  handler,"1", 88500, 10);
            drop(mv,  handler,"4", 89250, 10);
            drop(mv,  handler,"2", 90250, 10);
            drop(mv,  handler,"1", 91000, 10);//  repeat 1750
            drop(mv,  handler,"3", 91000, 10);
            drop(mv,  handler,"4", 91750, 10);
            drop(mv,  handler,"3", 92750, 10);
            drop(mv,  handler,"2", 93500, 10);
            drop(mv,  handler,"1", 94500, 10);
            drop(mv,  handler,"2", 95250, 10);
            drop(mv,  handler,"4", 96250, 10);
            drop(mv,  handler,"2", 97000, 10);
            drop(mv,  handler,"3", 97000, 10);
            drop(mv,  handler,"1", 98000, 10);
            drop(mv,  handler,"2", 98750, 10);
            drop(mv,  handler,"3", 101500, 10);
            drop(mv,  handler,"1", 103250, 10);
            drop(mv,  handler,"2", 104000, 10);
            drop(mv,  handler,"4", 105000, 10);
            drop(mv,  handler,"1", 105000, 10);
            drop(mv,  handler,"3", 106750, 10);
            drop(mv,  handler,"4", 107500, 10);
            drop(mv,  handler,"1", 107500, 10);
            drop(mv,  handler,"2", 108500, 10);
            drop(mv,  handler,"3", 109250, 10);
            drop(mv,  handler,"1", 110250, 10);
            drop(mv,  handler,"3", 111000, 10);
            drop(mv,  handler,"2", 112000, 10);
            drop(mv,  handler,"1", 112650, 10);
            drop(mv,  handler,"4", 113750, 10); // *
            drop(mv,  handler,"2", 114500, 10);
            drop(mv,  handler,"3", 115500, 10);
            drop(mv,  handler,"1", 117250, 10);
            drop(mv,  handler,"2", 119000, 10);
            drop(mv,  handler,"1", 119600, 10);
            drop(mv,  handler,"3", 120750, 10);
            drop(mv,  handler,"2", 120750, 10);
            drop(mv,  handler,"4", 122500, 10);
            drop(mv,  handler,"2", 123250, 10);
            drop(mv,  handler,"3", 124250, 10);
            drop(mv,  handler,"4", 124250, 10);
            drop(mv,  handler,"1", 126000, 10);
            drop(mv,  handler,"3", 126600, 10);
            drop(mv,  handler,"2", 127750, 10);
            drop(mv,  handler,"4", 129500, 10);
            drop(mv,  handler,"4", 131250, 10);
            drop(mv,  handler,"2", 131850, 10);
            drop(mv,  handler,"1", 131850, 10);
            drop(mv,  handler,"3", 133000, 10);
            drop(mv,  handler,"1", 134750, 10);
            drop(mv,  handler,"3", 136500, 10);
            drop(mv,  handler,"1", 137250, 10);
            drop(mv,  handler,"4", 138250, 10);
            drop(mv,  handler,"2", 138850, 10);
            drop(mv,  handler,"3", 140000, 10);
            drop(mv,  handler,"2", 141750, 10);
            drop(mv,  handler,"1", 143500, 10);
            drop(mv,  handler,"2", 143500, 10);
            drop(mv,  handler,"3", 145250, 10); // slow down
            drop(mv,  handler,"3", 150500, 10);
            drop(mv,  handler,"2", 150500, 10);
            drop(mv,  handler,"1", 150500, 10);
            drop(mv,  handler,"4", 150500, 10);
            drop(mv,  handler,"3", 154000, 10);
            drop(mv,  handler,"4", 154750, 10);
            drop(mv,  handler,"1", 157500, 10);
            drop(mv,  handler,"3", 158100, 10);
            drop(mv,  handler,"1", 161000, 10);
            drop(mv,  handler,"3", 161600, 10);
            drop(mv,  handler,"2", 162350, 10);
            drop(mv,  handler,"3", 163100, 10);
            drop(mv,  handler,"4", 163850, 10);
            drop(mv,  handler,"1", 164500, 10);
            drop(mv,  handler,"3", 164500, 10);
            drop(mv,  handler,"2", 165100, 10);
            drop(mv,  handler,"4", 165100, 10);
            drop(mv,  handler,"1", 165850, 10);
            drop(mv,  handler,"3", 166600, 10);
            drop(mv,  handler,"4", 167200, 10);
            drop(mv,  handler,"2", 168000, 10);
            drop(mv,  handler,"3", 168000, 10);
            drop(mv,  handler,"4", 171500, 10);
            drop(mv,  handler,"3", 171500, 10);
            drop(mv,  handler,"2", 171500, 10);
            drop(mv,  handler,"1", 171500, 10); // 2:50 (170)->stop
            drop(mv,  handler,"3", 175500, 10);
            drop(mv,  handler,"3", 177500, 10);
            drop(mv,  handler,"2", 179500, 10);
            drop(mv,  handler,"2", 181375, 10);
            drop(mv,  handler,"1", 183250, 10);
            drop(mv,  handler,"1", 185125, 10);
            drop(mv,  handler,"4", 185125, 10);
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

        final String m = intent.getStringExtra("title");
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

        final Intent sscore = new Intent(getApplicationContext(),ShowScore.class);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(sscore);

            }
        }, 10000); //3분 30초 = 210000

       //sscore.putExtra("score",Integer.toString(mv.iscore));

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Hello","Start");
        gameobject.run();
    }

}