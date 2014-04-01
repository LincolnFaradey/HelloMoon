package ru.homehell.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by faradey on 31.03.14.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;
    private boolean playing;

    public void stop() {
        playing = false;
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c){
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        playing = true;
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
    }

    public void pause(){
        playing = false;
        mPlayer.pause();
    }


    public boolean isPlaying(){
        return playing;
    }
}
