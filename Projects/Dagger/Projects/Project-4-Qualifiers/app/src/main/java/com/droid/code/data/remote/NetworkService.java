package com.droid.code.data.remote;

import android.content.Context;

import com.droid.code.di.qualifiers.NetworkInfo;

import javax.inject.Inject;

/**
 * Dummy class to simulate the actual NetworkService using Retrofit or OkHttp etc
 */
public class NetworkService {

    private Context context;
    private String apiKey;

    @Inject
    public NetworkService(Context context, @NetworkInfo String apiKey) {
        // do the initialisation here
        this.context = context;
        this.apiKey = apiKey;
    }

    public String getDummyData() {
        return "NETWORK_DUMMY_DATA";
    }
}
