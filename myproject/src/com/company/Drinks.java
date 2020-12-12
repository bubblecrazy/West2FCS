package com.company;

import java.time.LocalDate;

public abstract class Drinks {
    protected String name;
    protected double chengben;
    protected LocalDate shengchanriqi;
    protected long baozhiqi;

    public Drinks() {
    }

    public abstract String toString();

    public boolean isOver() {
        LocalDate today = LocalDate.now();
        if (this.shengchanriqi.plusDays(this.baozhiqi).isBefore(today)) {
            return true;
        }
        return false;
    }
}
