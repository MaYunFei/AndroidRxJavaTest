package io.github.mayunfei.androidrxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.github.mayunfei.network.BaseResult;
import io.github.mayunfei.network.NetWorkUtils;
import io.github.mayunfei.network.bean.Random;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    NetWorkUtils.getApi().getRandomData(10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<BaseResult<List<Random>>>() {
                @Override
                public void accept(@NonNull BaseResult<List<Random>> randomBaseResult) throws Exception {
                    for (Random random :
                            randomBaseResult.getResults()) {
                        Log.i("i ", random.toString());
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(@NonNull Throwable throwable) throws Exception {
                    Log.e("log","error = " + throwable);
                }
            });
  }
}
