package com.smartnet.jackpotandroidversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;
import com.smartnet.jackpotandroidversion.jackpot.ChaningValueHelper;
import com.smartnet.jackpotandroidversion.server.UdpServer;
import com.smartnet.jackpotandroidversion.video.VideoScene;

import java.net.SocketException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        InitViewHelper.initViewHelper(this);
        runUdp();
    }

    @Override
    protected void onResume() {
        VideoScene.getInstance(this, R.id.video_view_no_winner).playVideo(false);
        super.onResume();
    }

    private void runUdp() {
        try {
            UdpServer.getInstance(this).runUdpServer();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}