package com.example.gsabev.diceroller;

import java.util.Random;

/**
 * Created by gsabev on 11.6.2017 г..
 */

public class Dice {
    private int diceValue;

    public Dice() {
        this.diceValue = getRandom();
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }


    private int getRandom() {
        Random rand = new Random();
        int randNum = rand.nextInt(6) + 1;
        return randNum;
    }
}
