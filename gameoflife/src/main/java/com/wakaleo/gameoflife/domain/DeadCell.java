package com.wakaleo.gameoflife.domain;

public class DeadCell extends Cell {

    public static final char SYMBOL = '-';

    @Override
    public Boolean isAlive() {
        return false;
    }

    @Override
    public Cell nextGeneration(int neighbourCount) {
        if (neighbourCount == 3) {
            return new LivingCell();
        } else {
            return new DeadCell();
        }
    }

    @Override
    public String toString() {
        return Character.toString(SYMBOL);
    }
    
}
