package com.example.user.exchangeexample;

/**
 * Created by user on 25.07.17.
 */

public interface RequiredViewOps {
    void showCurrentRate(String currency);
    void showResult(String result);
    void showToast(String message);
    String getCurrentRate();
    String getValue();
    String getResult();
}
