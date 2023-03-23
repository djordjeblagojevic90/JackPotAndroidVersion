package com.smartnet.jackpotandroidversion;

import android.view.Gravity;
import android.view.animation.OvershootInterpolator;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

public class InitViewHelper {

    private static InitViewHelper instance;
    private MainActivity mainActivity;
    private TickerView grand;
    private TickerView mega;
    private TickerView maxi;
    private TickerView midi;
    private TickerView mini;


    public InitViewHelper(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    public static InitViewHelper getInstance() {
        return instance;
    }

    public static InitViewHelper initViewHelper(MainActivity mainActivity) {
        if (instance == null) {
            instance = new InitViewHelper(mainActivity);
        }
        instance.initViews();
        return instance;
    }

    public TickerView getGrand() {
        return grand;
    }

    public TickerView getMega() {
        return mega;
    }

    public TickerView getMaxi() {
        return maxi;
    }

    public TickerView getMidi() {
        return midi;
    }

    public TickerView getMini() {
        return mini;
    }

    private void initViews() {
        provideGrand();
        provideMega();
        provideMaxi();
        provideMidi();
        provideMini();
    }


    private void provideGrand() {
        grand = mainActivity.findViewById(R.id.tickerView_grand);
        grand.setAnimationDuration(60);
        grand.setAnimationInterpolator(new OvershootInterpolator());
        grand.setGravity(Gravity.START);
        grand.setCharacterLists(TickerUtils.provideNumberList());
        grand.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
    }

    private void provideMega() {
        mega = mainActivity.findViewById(R.id.tickerView_mega);
        mega.setAnimationDuration(60);
        mega.setAnimationInterpolator(new OvershootInterpolator());
        mega.setGravity(Gravity.START);
        mega.setCharacterLists(TickerUtils.provideNumberList());
        mega.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
    }

    private void provideMaxi() {
        maxi = mainActivity.findViewById(R.id.tickerView_maxi);
        maxi.setAnimationDuration(60);
        maxi.setAnimationInterpolator(new OvershootInterpolator());
        maxi.setGravity(Gravity.START);
        maxi.setCharacterLists(TickerUtils.provideNumberList());
        maxi.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);

    }

    private void provideMidi() {
        midi = mainActivity.findViewById(R.id.tickerView_midi);
        midi.setAnimationDuration(60);
        midi.setAnimationInterpolator(new OvershootInterpolator());
        midi.setGravity(Gravity.START);
        midi.setCharacterLists(TickerUtils.provideNumberList());
        midi.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
    }

    private void provideMini() {
        mini = mainActivity.findViewById(R.id.tickerView_mini);
        mini.setAnimationDuration(60);
        mini.setAnimationInterpolator(new OvershootInterpolator());
        mini.setGravity(Gravity.START);
        mini.setCharacterLists(TickerUtils.provideNumberList());
        mini.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
    }
}
