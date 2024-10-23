package com.example;

import java.util.List;

public class Lion {
    private boolean hasMane;
    private Predator predator;

    public Lion(String sex, Predator predator) {
        this.predator = predator;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new IllegalArgumentException("Используйте допустимые значения пола: Самец или Самка");
        }
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public int getKittens() {
        return ((Feline) predator).getKittens();
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}