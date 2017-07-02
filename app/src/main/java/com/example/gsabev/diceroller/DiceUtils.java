package com.example.gsabev.diceroller;

import android.widget.ImageView;

/**
 * Created by gsabev on 17.6.2017 г..
 */

public class DiceUtils {
    public static void setDiceIcon(Dice dc, ImageView iv) {
        switch (dc.getDiceValue()) {
            case 1:
                iv.setImageResource(R.drawable.a);
                break;
            case 2:
                iv.setImageResource(R.drawable.b);
                break;
            case 3:
                iv.setImageResource(R.drawable.c);
                break;
            case 4:
                iv.setImageResource(R.drawable.d);
                break;
            case 5:
                iv.setImageResource(R.drawable.e);
                break;
            case 6:
                iv.setImageResource(R.drawable.f);
                break;
        }
    }
}
