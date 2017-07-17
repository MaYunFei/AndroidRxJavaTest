package io.github.mayunfei.network;

import java.util.List;

import io.github.mayunfei.network.bean.Random;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 接口
 * Created by yunfei on 17-7-11.
 */

public interface GanKApi {


    @GET("random/data/Android/{count}")
    Observable<BaseResult<List<Random>>> getRandomData(@Path("count") int count);



}
