package com.example.user.exchangeexample.module;

import android.content.Context;

import com.example.user.exchangeexample.manager.DatabaseManager;
import com.example.user.exchangeexample.manager.NetworkManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 24.07.17.
 */
@Module
public class ManagerModule {
    private Context context;

    public ManagerModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public NetworkManager provideNetworkManager() {
        return new NetworkManager();
    }

    @Provides
    @Singleton
    public DatabaseManager provideDatabaseManager() {
        return new DatabaseManager(context);
    }
}
