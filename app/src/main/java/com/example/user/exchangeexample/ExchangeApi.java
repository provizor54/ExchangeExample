package com.example.user.exchangeexample;

import com.example.user.exchangeexample.model.Currency;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 24.07.17.
 */

public interface ExchangeApi {
    @GET("latest?symbols=USD")
    Observable<Currency> getPosts();
}
