package com.example.user.exchangeexample;

import android.app.Application;

import com.example.user.exchangeexample.component.AppComponent;
import com.example.user.exchangeexample.component.DaggerAppComponent;
import com.example.user.exchangeexample.module.ManagerModule;

/**
 * Created by user on 24.07.17.
 */

public class App extends Application {
    public static AppComponent component;

    public static AppComponent getComponentInstance() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .managerModule(new ManagerModule(this))
                .build();
    }
}