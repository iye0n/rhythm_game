package com.example.iwtgh;

import android.content.Context;
import android.media.MediaPlayer;

public class Music {
    private MediaPlayer music;

    //인자로 전달하는 방법은 없나..?
    public Music(Context context, String m){
        music = new MediaPlayer();
        switch(m){
            case "bgm":
                music = MediaPlayer.create(context, R.raw.bgm);
            case "nodab":
                music = MediaPlayer.create(context, R.raw.nodab);
        }

    }

    public void startMusic(){
        music.start();
    }

    public void stopMusic(){
        music.stop();
        music.reset();
    }
}