package io.github.mayunfei.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mayunfei on 17-7-17.
 */

public class NetWorkUtils {
    private static Retrofit retrofit;
    private static GanKApi ganKApi;

    static {
        retrofit = new Retrofit.Builder().baseUrl("http://gank.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ganKApi = retrofit.create(GanKApi.class);
    }

    public static GanKApi getApi() {
        return ganKApi;
    }

}
