package io.github.mayunfei.rx;

/**
 * Created by mayunfei on 17-8-29.
 */

public class ObservableFlatMap<T,U> extends AbstractObservableWithUpstream<T,U> {
    Function<? super T, ? extends ObservableSource<? extends U>> function;

    public ObservableFlatMap(Observable<T> source,Function<? super T, ? extends ObservableSource<? extends U>> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer<? super U> observer) {
        source.subscribe(new FlatMapObserver(observer,function));
    }


    private class FlatMapObserver implements Observer<T> {
        public FlatMapObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        }

        @Override
        public void onNext(T t) {

        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onError() {

        }
    }
}
