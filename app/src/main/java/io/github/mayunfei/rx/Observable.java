package io.github.mayunfei.rx;

/**
 * Created by mayunfei on 17-8-29.
 */

public abstract class Observable<T> implements ObservableSource<T> {
    @Override
    public void subscribe(Observer<? super T> observer) {
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<? super T> observer);


    public static <T> Observable<T> create(Observable<T> source){
        return new ObservableCreate<T>(source);
    }

    public <U> Observable<U> map(Function<? super T, ? extends U>  function){
        return new ObservableMap<T,U>(this,function);
    }

    public Observable<T> subscribeOn(){
        return new ObservableSubscribeOn<T>(this);
    }

    public final Observable<T> observeOn(){
        return new ObservableObserveOn<T>(this);
    }
}
