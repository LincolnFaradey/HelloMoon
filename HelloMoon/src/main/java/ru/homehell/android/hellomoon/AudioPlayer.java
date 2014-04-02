package ru.homehell.android.hellomoon;


import android.content.Context;
;
import android.media.MediaPlayer;



/**
 * Created by faradey on 31.03.14.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;
    private int pos = 0;


    public void stop() {

        if (mPlayer != null) {
            mPlayer.release();
            pos = 0;
            mPlayer = null;
        }
    }

    public void play(final Context c) {
        if (mPlayer != null) mPlayer.release();
        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();

            }
        });

        mPlayer.seekTo(pos-1);
        mPlayer.start();

    }

    public void pause(){

        if (mPlayer != null){
            mPlayer.pause();
            pos = mPlayer.getCurrentPosition();
        }

    }



}
