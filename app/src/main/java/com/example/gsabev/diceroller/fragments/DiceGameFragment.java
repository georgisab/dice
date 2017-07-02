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
public class DiceGameFragment extends Fragment {
    ImageView iv_cpu, iv_player;
    TextView tv_cpu, tv_player;
    Integer cpuPoints = 0 , plPloints = 0;
    LinearLayout ll_play;
    Dice diceCpu;
    Dice dicePlayer;

    public DiceGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_dice_game, container, false);
        iv_cpu = (ImageView) root.findViewById(R.id.iv_dice_cpu);
        iv_player = (ImageView) root.findViewById(R.id.iv_dice_player);
        ll_play = (LinearLayout) root.findViewById(R.id.ll_play_area);
        tv_cpu = (TextView) root.findViewById(R.id.tv_cpu);
        tv_player = (TextView) root.findViewById(R.id.tv_player);

        ll_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceCpu = new Dice();
                dicePlayer = new Dice();
                DiceUtils.setDiceIcon(diceCpu, iv_cpu);
                DiceUtils.setDiceIcon(dicePlayer, iv_player);

                if(diceCpu.getDiceValue() > dicePlayer.getDiceValue()){
                    cpuPoints++;
                }
                if(diceCpu.getDiceValue() < dicePlayer.getDiceValue()){
                    plPloints++;
                }

                tv_cpu.setText("CPU :"+ cpuPoints);
                tv_player.setText("You :"+ plPloints);

                Animation rotareAnimation = AnimationUtils.loadAnimation(root.getContext().getApplicationContext(), R.anim.rotate);
                iv_cpu.startAnimation(rotareAnimation);
                iv_player.startAnimation(rotareAnimation);
            }
        });

        return root;
    }

}
