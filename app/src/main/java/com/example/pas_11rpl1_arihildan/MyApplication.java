package com.example.pas_11rpl1_arihildan;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("movie.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}