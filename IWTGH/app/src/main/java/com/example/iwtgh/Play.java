package com.example.iwtgh;

public class Play extends GameObject {

    private int score;
    private double dy;
    private boolean up;
    private boolean playing = false;

    private long startTime;
    private int node;
    private double deg;
    private double wid;

    private GameScreen gameScreen;

    private float yy = 0;

    public Play(int x, int y, int r, int playSize){
        node = r + 10;
        objectSize = playSize;

        width = x;
        height = y;

        score = 0;

        deg = 180;

        dx = this.objectSize;
        dy = this.objectSize;

        startTime = System.nanoTime();
    }

    public void setUp(boolean b){
        up = b;
    }

    public void setNode(){
        if(node > 300)
            node = 290;

        else
            node = 310;

    }
}
