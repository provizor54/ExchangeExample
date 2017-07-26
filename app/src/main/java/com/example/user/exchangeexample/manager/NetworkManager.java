package com.example.user.exchangeexample.manager;

import com.example.user.exchangeexample.App;
import com.example.user.exchangeexample.Const;
import com.example.user.exchangeexample.ExchangeApi;
import com.example.user.exchangeexample.model.Currency;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 24.07.17.
 */
public class NetworkManager {
    Retrofit retrofit;

    public NetworkManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Observable<Currency> getCurrency() {
        return retrofit.create(ExchangeApi.class).getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
