package com.example.iwtgh;

import android.content.Context;
import android.media.MediaPlayer;

public class Music {
    private MediaPlayer music;

    //인자로 전달하는 방법은 없나..?
    public Music(Context context, String m, boolean t){
        music = new MediaPlayer();
        switch(m){
            case "bgm":
                music = MediaPlayer.create(context, R.raw.bgm);
                music.setLooping(t);
                break;
            case "nodab":
                music = MediaPlayer.create(context, R.raw.nodab);
                music.setLooping(t);
                break;
            case "gogobebe":
                music = MediaPlayer.create(context, R.raw.gogobebe);
                music.setLooping(t);
                break;
            case "badguy":
                music = MediaPlayer.create(context, R.raw.badguy);
                music.setLooping(t);
                break;
            case "perfect":
                music = MediaPlayer.create(context, R.raw.perfect);
                music.setLooping(t);
                break;
            case "stay":
                music = MediaPlayer.create(context, R.raw.stay);
                music.setLooping(t);
                break;
        }
        startMusic();
    }

    public Music(){
    }


    public void startMusic(){
        music.start();
    }

    public void stopMusic(){
        music.stop();
        music.reset();
    }
}