package com.smartnet.jackpotandroidversion.video;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.smartnet.jackpotandroidversion.R;
import com.smartnet.jackpotandroidversion.jackpot.model.JackpotModel;

public class VideoScene {

    private VideoView videoView;
    private final String TAG = "VideoScene";
    private static VideoScene instance;
    private AppCompatActivity appCompatActivity;
    private String VIDEO_NO_WINNER;
    private String VIDEO_WINNER;
    private int sec;


    public static VideoScene getInstance(AppCompatActivity appCompatActivity, int id) {
        instance = new VideoScene();
        instance.VIDEO_NO_WINNER = "android.resource://" + appCompatActivity.getPackageName() + "/" + R.raw.jackpot_no_winner;
        instance.VIDEO_WINNER = "android.resource://" + appCompatActivity.getPackageName() + "/" + R.raw.jackpot_winner;
        Log.i(instance.TAG, instance.TAG + " is created");
        instance.appCompatActivity = appCompatActivity;
        instance.provideVideoView(id);
        return instance;
    }


    private void provideVideoView(int id) {
        videoView = appCompatActivity.findViewById(id);
    }


    public void playVideo(boolean winner) {
        if (!winner) {
            Uri uri = Uri.parse(VIDEO_NO_WINNER);
            videoView.setVideoURI(uri);
            videoView.start();
            repeatVideo();
        } else {
            Uri uri = Uri.parse(VIDEO_WINNER);
            videoView.setVideoURI(uri);
            videoView.start();
            displayDataAndChangeScreen();
        }
    }


    private void displayDataAndChangeScreen() {
        TextView txt_amount = appCompatActivity.findViewById(R.id.txt_amount);
        TextView txt_gm = appCompatActivity.findViewById(R.id.txt_gm);
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sec = sec + 1;
                if (sec == 13) {
                    //display first set of data
                    txt_amount.setText("" + JackpotModel.getInstance().getWin_amnt());
                    txt_amount.setVisibility(View.VISIBLE);
                } else if (sec == 18) {
                    txt_gm.setText("" + JackpotModel.getInstance().getWin_gm());
                    txt_gm.findViewById(R.id.txt_gm).setVisibility(View.VISIBLE);
                    //display secound set od data
                } else if (sec == 31) {
                    appCompatActivity.finish();
                }
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 0);
    }

    private void repeatVideo() {
        Handler handler = new Handler();
        Runnable runnable = () -> {
            if (!videoView.isPlaying()) {
                videoView.start();
            }
            handler.postDelayed(this::repeatVideo, 1000);
        };
        handler.postDelayed(runnable, 0);
    }
}
