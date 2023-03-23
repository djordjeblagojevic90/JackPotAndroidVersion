package com.smartnet.jackpotandroidversion.server;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.smartnet.jackpotandroidversion.InitViewHelper;
import com.smartnet.jackpotandroidversion.MainActivity;
import com.smartnet.jackpotandroidversion.WinnerActivity;
import com.smartnet.jackpotandroidversion.jackpot.ChaningValueHelper;
import com.smartnet.jackpotandroidversion.jackpot.model.JackpotModel;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {

    public static UdpServer instance;
    byte[] receiveData = new byte[5064];
    DatagramSocket udpSocket;
    Thread thread;
    private boolean doWork = true;
    private final String TAG = "UdpServer";
    private Handler handler;
    private boolean startingValue = true;
    private MainActivity mainActivity;

    public UdpServer(MainActivity mainActivity) throws SocketException {
        udpSocket = new DatagramSocket(1805);
        handler = new Handler(Looper.getMainLooper());
        this.mainActivity = mainActivity;
    }


    /**
     * Helper to create UdpServer instance
     *
     * @return instance of udpServer class
     */
    public static UdpServer getInstance(MainActivity mainActivity) throws SocketException {
        if (instance == null) {
            instance = new UdpServer(mainActivity);
        }
        return instance;
    }


    /**
     * Helper to run udp server
     */
    public void runUdpServer() {
        thread = new Thread(() -> {
            try {
                doWork();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }


    /**
     * Helper method to stop udp server runing
     */
    public void closeUdpServer() {
        doWork = false;
    }


    /**
     * Helper to handle udp request
     */
    private void doWork() throws IOException {
        while (doWork) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            udpSocket.receive(receivePacket);
            StringBuilder receiveData = data(receivePacket.getData());
            changeValues(receiveData);
            Log.v(TAG, receiveData.toString());
        }
    }

    private void changeValues(StringBuilder receiveData) {
        JackpotModel.getInstance().initInstance(receiveData.toString());
        if (startingValue) {
            ChaningValueHelper.getInstance().setInitialValue(InitViewHelper.getInstance().getGrand(), InitViewHelper.getInstance().getMega(),
                    InitViewHelper.getInstance().getMaxi(), InitViewHelper.getInstance().getMidi(), InitViewHelper.getInstance().getMini());
            startingValue = false;
        } else if (JackpotModel.getInstance().getWin_gm() == 0) {
            ChaningValueHelper.getInstance().doActions();
        } else {
            Intent intent = new Intent(mainActivity, WinnerActivity.class);
            mainActivity.startActivity(intent);
        }

    }

    /**
     * Helper method to convert byte array to string
     *
     * @param a
     * @return
     */
    public static StringBuilder data(byte[] a) {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
