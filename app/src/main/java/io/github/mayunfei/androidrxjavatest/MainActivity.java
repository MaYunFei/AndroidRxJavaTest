package io.github.mayunfei.androidrxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        NetWorkUtils.getApi().getRandomData(10)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<BaseResult<List<Random>>>() {
//                    @Override
//                    public void accept(@NonNull BaseResult<List<Random>> randomBaseResult) throws Exception {
//                        for (Random random :
//                                randomBaseResult.getResults()) {
//                            Log.i("i ", random.toString());
//                        }
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(@NonNull Throwable throwable) throws Exception {
//                        Log.e("log", "error = " + throwable);
//                    }
//                });
        new Thread(new Runnable() {
            @Override
            public void run() {
                io.github.mayunfei.rx.Observable.create(new io.github.mayunfei.rx.Observable<String>() {
                    @Override
                    protected void subscribeActual(io.github.mayunfei.rx.Observer<? super String> observer) {
                        Log.e(TAG,"subscribeActual" +" "+ Thread.currentThread().getName());
                        observer.onNext("hello");
                        observer.onNext("world");
                        observer.onComplete();
                    }
                })

                        .subscribeOn()
                        .map(new io.github.mayunfei.rx.Function<String, String>() {
                            @Override
                            public String apply(String s) {
                                Log.e(TAG,"map" +" "+ Thread.currentThread().getName());
                                return s + "  888";
                            }
                        })
                        .observeOn()
                        .subscribe(new io.github.mayunfei.rx.Observer<String>() {
                            @Override
                            public void onNext(String s) {
                                Log.e(TAG,"subscribe" +" "+ Thread.currentThread().getName());
                                Log.i(TAG, s);
                            }

                            @Override
                            public void onComplete() {
                                Log.i(TAG, "onComplete");
                            }

                            @Override
                            public void onError() {

                            }
                        });
            }
        }).start();


//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
//                Log.i(TAG, "create thread = " + Thread.currentThread().toString());
//                e.onNext("Hello");
//                e.onComplete();
//            }
//        })
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(@NonNull Disposable disposable) throws Exception {
//                        Log.i(TAG, "doOnSubscribe thread = " + Thread.currentThread().toString());
//                    }
//                })
//
//                .subscribeOn(Schedulers.io())
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(@NonNull String s) throws Exception {
//                        Log.i(TAG, "map thread = " + Thread.currentThread().toString());
//                        return s + " World";
//                    }
//                })
//
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.i(TAG, "onSubscribe thread = " + Thread.currentThread().toString());
//                    }
//
//                    @Override
//                    public void onNext(@NonNull String s) {
//                        Log.e(TAG, s);
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//
//                    @Override
//                    public String toString() {
//                        return super.toString();
//                    }
//                });


//      Observable.just("Hello")
//
//              .map(new Function<String, Integer>() {
//                  @Override
//                  public Integer apply(@NonNull String s) throws Exception {
//                      return null;
//                  }
//              }).flatMap(new Function<Integer, ObservableSource<Integer>>() {
//          @Override
//          public ObservableSource<Integer> apply(@NonNull Integer integer) throws Exception {
//              return null;
//          }
//      })
//              .subscribeOn(Schedulers.io())
//              .observeOn(Schedulers.newThread())
//              .subscribe(new Observer<Integer>() {
//                  @Override
//                  public void onSubscribe(@NonNull Disposable d) {
//
//                  }
//
//                  @Override
//                  public void onNext(@NonNull Integer integer) {
//
//                  }
//
//                  @Override
//                  public void onError(@NonNull Throwable e) {
//
//                  }
//
//                  @Override
//                  public void onComplete() {
//
//                  }
//              })
//
//      ;
    }
}
