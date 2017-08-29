package io.github.mayunfei.rx;

/**
 * Created by mayunfei on 17-8-29.
 */

public class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    private Function<? super T, ? extends U> function;

    public ObservableMap(Observable<T> source, Function<? super T, ? extends U> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer<? super U> observer) {
        source.subscribe(new MapObserver(observer, function));
    }


    public class MapObserver implements Observer<T> {

        private final Observer<? super U> source;

        public MapObserver(Observer<? super U> source, Function<? super T, ? extends U> function) {
            this.function = function;
            this.source = source;
        }

        private Function<? super T, ? extends U> function;


        @Override
        public void onNext(T t) {
            source.onNext(function.apply(t));
        }

        @Override
        public void onComplete() {
            source.onComplete();
        }

        @Override
        public void onError() {
            source.onError();
        }
    }
}
