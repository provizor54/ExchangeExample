package com.example.user.exchangeexample.component;

import com.example.user.exchangeexample.HistoryActivity;
import com.example.user.exchangeexample.MainActivity;
import com.example.user.exchangeexample.MainPresenter;
import com.example.user.exchangeexample.module.ManagerModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by user on 24.07.17.
 */

@Component(modules = {ManagerModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(HistoryActivity historyActivity);
    void inject(MainPresenter mainPresenter);
}
