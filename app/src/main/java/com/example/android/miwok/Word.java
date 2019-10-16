package com.example.android.miwok;

import android.media.MediaPlayer;
import android.widget.ImageView;

public class Word {
    private String miwok,eng;
    private int imID = NO_IMAGE_PROVIDE;
    private static final int NO_IMAGE_PROVIDE = -1;
    private  int mpid;
    public Word(String mi, String en,int mp){
        miwok=mi;
        eng=en;
        mpid=mp;
    }
    public Word(String mi, String en, int i,int mp){
        miwok=mi;
        eng=en;
        imID=i;
        mpid=mp;
    }
    public String getmiwok() {
        return miwok;
    }
    public String geteng(){
        return eng;
    }
    public int getImID(){
        return imID;
    }
    public int getMpid(){return mpid;}
    public boolean hasimage(){
        return imID!=NO_IMAGE_PROVIDE;
    }
}
