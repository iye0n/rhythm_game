package com.example.iwtgh;

import android.content.Context;
import android.support.annotation.MainThread;
import android.text.style.BackgroundColorSpan;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import javazoom.jl.player.Player;

public abstract class GameScreen extends SurfaceView implements SurfaceHolder.Callback {

    public static int WIDTH;
    public static int HEIGHT;

    private MainThread thread;




    public GameScreen(Context context) {
        super(context);
    }
}
