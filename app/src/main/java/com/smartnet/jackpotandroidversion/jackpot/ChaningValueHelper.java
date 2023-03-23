package com.smartnet.jackpotandroidversion.jackpot;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.robinhood.ticker.TickerView;
import com.smartnet.jackpotandroidversion.InitViewHelper;
import com.smartnet.jackpotandroidversion.jackpot.model.JackpotModel;

public class ChaningValueHelper {

    private static ChaningValueHelper instance;
    private final String TAG = "ChaningValueHelper";


    public static ChaningValueHelper getInstance() {
        if (instance == null) {
            instance = new ChaningValueHelper();
            Log.i(instance.TAG, instance.TAG + " is created");
        }
        return instance;
    }


    public void setInitialValue(TickerView grand, TickerView mega, TickerView maxi, TickerView midi, TickerView mini) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(() -> {
            grand.setText(JackpotModel.getInstance().getJp1());
            mega.setText(JackpotModel.getInstance().getJp2());
            maxi.setText(JackpotModel.getInstance().getJp3());
            midi.setText(JackpotModel.getInstance().getJp4());
            mini.setText(JackpotModel.getInstance().getJp5());
        });
    }


    public void doActions() {
        if (JackpotModel.getInstance().getWin_gm() == 0) {
            //Change value with ticker view animation
            tickerGrandAction(InitViewHelper.getInstance().getGrand());
            tickerMegaAction(InitViewHelper.getInstance().getMega());
            tickerMaxiAction(InitViewHelper.getInstance().getMaxi());
            tickerMiniAction(InitViewHelper.getInstance().getMini());
            tickerMidiAction(InitViewHelper.getInstance().getMidi());
        } else if (JackpotModel.getInstance().getWin_gm() != 0) {
            //Change screen
        }
    }

    private void tickerGrandAction(TickerView grand) {
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                double valueGrand = 0;
                try {
                    valueGrand = Double.parseDouble(grand.getText());
                } catch (NumberFormatException e) {
                    Log.i(TAG, e.getLocalizedMessage());
                }
                valueGrand = valueGrand + 0.15;
                String grandText = String.valueOf(valueGrand);
                try {
                    grandText = grandText.substring(0, grandText.indexOf(".") + 3);
                } catch (IndexOutOfBoundsException e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
                grand.setText(grandText);
                if (valueGrand <= Double.parseDouble(JackpotModel.getInstance().getJp1())) {
                    handler.postDelayed(this, 50);
                } else {
                    grand.setText(JackpotModel.getInstance().getJp1());
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    private void tickerMegaAction(TickerView mega) {
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                double valueMega = 0;
                try {
                    valueMega = Double.parseDouble(mega.getText());
                } catch (NumberFormatException e) {
                    Log.i(TAG, e.getLocalizedMessage());
                }
                valueMega = valueMega + 0.15;
                String megaText = String.valueOf(valueMega);
                try {
                    megaText = megaText.substring(0, megaText.indexOf(".") + 3);
                } catch (IndexOutOfBoundsException e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
                mega.setText(megaText);
                if (valueMega <= Double.parseDouble(JackpotModel.getInstance().getJp2())) {
                    handler.postDelayed(this, 50);
                } else {
                    mega.setText(JackpotModel.getInstance().getJp2());
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    private void tickerMaxiAction(TickerView maxi) {
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                double valueMaxi = 0;
                try {
                    valueMaxi = Double.parseDouble(maxi.getText());
                } catch (NumberFormatException e) {
                    Log.i(TAG, e.getLocalizedMessage());
                }
                valueMaxi = valueMaxi + 0.15;
                String maxiText = String.valueOf(valueMaxi);
                try {
                    maxiText = maxiText.substring(0, maxiText.indexOf(".") + 3);
                } catch (IndexOutOfBoundsException e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
                maxi.setText(maxiText);
                if (valueMaxi <= Double.parseDouble(JackpotModel.getInstance().getJp3())) {
                    handler.postDelayed(this, 50);
                } else {
                    maxi.setText(JackpotModel.getInstance().getJp3());
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    private void tickerMiniAction(TickerView mini) {
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                double valueMini = 0;
                try {
                    valueMini = Double.parseDouble(mini.getText());
                } catch (NumberFormatException e) {
                    Log.i(TAG, e.getLocalizedMessage());
                }
                valueMini = valueMini + 0.15;
                String miniText = String.valueOf(valueMini);
                try {
                    miniText = miniText.substring(0, miniText.indexOf(".") + 3);
                } catch (IndexOutOfBoundsException e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
                mini.setText(miniText);
                if (valueMini <= Double.parseDouble(JackpotModel.getInstance().getJp5())) {
                    handler.postDelayed(this, 50);
                } else {
                    mini.setText(JackpotModel.getInstance().getJp5());
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

    private void tickerMidiAction(TickerView midi) {
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                double valueMidi = 0;
                try {
                    valueMidi = Double.parseDouble(midi.getText());
                } catch (NumberFormatException e) {
                    Log.i(TAG, e.getLocalizedMessage());
                }
                valueMidi = valueMidi + 0.15;
                String midiText = String.valueOf(valueMidi);
                try {
                    midiText = midiText.substring(0, midiText.indexOf(".") + 3);
                } catch (IndexOutOfBoundsException e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
                midi.setText(midiText);
                if (valueMidi <= Double.parseDouble(JackpotModel.getInstance().getJp4())) {
                    handler.postDelayed(this, 50);
                } else {
                    midi.setText(JackpotModel.getInstance().getJp4());
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }
}
