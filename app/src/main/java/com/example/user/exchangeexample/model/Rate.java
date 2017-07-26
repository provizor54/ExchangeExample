package com.example.user.exchangeexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 24.07.17.
 */

public class Rate {
    @SerializedName("USD")
    @Expose
    private String currency;

    public Rate(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
