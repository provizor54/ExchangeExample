package com.example.user.exchangeexample;

/**
 * Created by user on 25.07.17.
 */

public interface PresenterOps {
    void getCurrentRate();
    void calculate(double value, double currentRate);
}
