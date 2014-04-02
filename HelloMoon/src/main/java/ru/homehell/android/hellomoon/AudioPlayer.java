package ru.homehell.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by faradey on 31.03.14.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;
    private int pos;

    public void stop() {

        if (mPlayer != null) {
            mPlayer.release();
            pos = 0;
            mPlayer = null;
        }
    }

    public void play(Context c) {
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mPlayer.start();
    }

    public void pause(){
        if (mPlayer.isPlaying() && mPlayer != null){
            mPlayer.pause();
        }
    }



}
