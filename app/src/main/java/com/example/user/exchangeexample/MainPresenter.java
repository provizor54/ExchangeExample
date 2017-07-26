package com.example.user.exchangeexample;

import android.content.Context;
import android.util.Log;

import com.example.user.exchangeexample.manager.DatabaseManager;
import com.example.user.exchangeexample.manager.NetworkManager;
import com.example.user.exchangeexample.model.Currency;
import com.example.user.exchangeexample.model.History;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by user on 25.07.17.
 */

public class MainPresenter implements PresenterOps {
    @Inject
    NetworkManager networkManager;
    @Inject
    DatabaseManager databaseManager;
    private Context context;

    private RequiredViewOps requiredViewOps;

    public MainPresenter(Context context, RequiredViewOps requiredViewOps) {
        this.context = context;
        this.requiredViewOps = requiredViewOps;
        App.getComponentInstance().inject(this);
    }

    @Override
    public void getCurrentRate() {
        networkManager.getCurrency().subscribe(new Observer<Currency>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Currency currency) {
                requiredViewOps.showCurrentRate(currency.getRates().getCurrency());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void calculate(double value, double currentRate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(new Date());

        double result = value * currentRate;
        requiredViewOps.showResult(String.valueOf(result));
        databaseManager.insertHistory(new History(date, currentRate, value, result));
    }
}
