package com.example.gsabev.diceroller.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.gsabev.diceroller.Dice;

import com.example.gsabev.diceroller.DiceUtils;
import com.example.gsabev.diceroller.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiceMainFragment extends Fragment {
    ImageView iv_dive_one, iv_dive_two;
    LinearLayout dice_area;
    TextView lastresult;
    Dice diceOne;
    Dice diceTwo;

    public DiceMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dice_main, container, false);
        iv_dive_one = (ImageView) root.findViewById(R.id.iv_dice_one);
        iv_dive_two = (ImageView) root.findViewById(R.id.iv_dice_two);
        dice_area = (LinearLayout) root.findViewById(R.id.ll_dive_area);
        lastresult = (TextView) root.findViewById(R.id.tv_last_score);

        dice_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((null != diceOne) && (null != diceTwo) ){
                    lastresult.setText(setLatsScore(diceOne,diceTwo));
                }
                diceOne = new Dice();
                diceTwo = new Dice();
                Animation rotareAnimation = AnimationUtils.loadAnimation(root.getContext().getApplicationContext(), R.anim.rotate);

                iv_dive_one.setAnimation(rotareAnimation);
                iv_dive_two.setAnimation(rotareAnimation);
                DiceUtils.setDiceIcon(diceOne, iv_dive_one);
                DiceUtils.setDiceIcon(diceTwo, iv_dive_two);
            }
        });
        // Inflate the layout for this fragment
        return root;
    }
    private String setLatsScore(Dice one, Dice two){
        return "Last dice scores are: "+ one.getDiceValue() +" : " + two.getDiceValue();
    };
}
