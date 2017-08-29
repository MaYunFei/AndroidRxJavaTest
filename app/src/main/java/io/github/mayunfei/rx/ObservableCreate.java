package io.github.mayunfei.rx;

import io.reactivex.*;

/**
 * Created by mayunfei on 17-8-29.
 */

public class ObservableCreate<T> extends Observable<T> {

    private Observable<T> source;

    public ObservableCreate(Observable<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {
            source.subscribe(observer);
    }
}
