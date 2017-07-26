package com.example.user.exchangeexample.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by user on 24.07.17.
 */
@Entity
public class History {
    @Id
    private long id;
    @NotNull
    private String date;
    @NotNull
    private double currentRate;
    @NotNull
    private double value;
    @NotNull
    private double result;
    @Keep
    public History(@NotNull String date, double currentRate, double value,
            double result) {
        this.id = System.currentTimeMillis();
        this.date = date;
        this.currentRate = currentRate;
        this.value = value;
        this.result = result;
    }

    @Generated(hash = 830733449)
    public History(long id, @NotNull String date, double currentRate, double value,
            double result) {
        this.id = id;
        this.date = date;
        this.currentRate = currentRate;
        this.value = value;
        this.result = result;
    }

    @Generated(hash = 869423138)
    public History() {
    }
    
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getCurrentRate() {
        return this.currentRate;
    }
    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }
    public double getValue() {
        return this.value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public double getResult() {
        return this.result;
    }
    public void setResult(double result) {
        this.result = result;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
