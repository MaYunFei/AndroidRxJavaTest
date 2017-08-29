package io.github.mayunfei.rx;

/**
 * Created by mayunfei on 17-8-29.
 */

public interface Observer<T> {
    void onNext(T t);
    void onComplete();
    void onError();
}
