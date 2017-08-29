package io.github.mayunfei.rx;


/**
 *
 * Created by mayunfei on 17-8-29.
 */

public abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> {
    protected Observable<T> source;

    public AbstractObservableWithUpstream(Observable<T> source) {
        this.source = source;
    }
}
