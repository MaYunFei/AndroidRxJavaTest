package io.github.mayunfei.rx;

/**
 * Created by mayunfei on 17-8-29.
 */

public interface ObservableSource<T> {
    void subscribe(Observer<? super T> observer);
}
