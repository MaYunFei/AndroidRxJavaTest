package io.github.mayunfei.rx;

import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;

/**
 * Created by mayunfei on 17-8-29.
 */

public class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T,T> {
    public ObservableObserveOn(Observable<T> source) {
        super(source);
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {
        source.subscribe(new ObserveOnObserver(observer));
    }

    class ObserveOnObserver implements Observer<T> ,Runnable{
        Observer<? super T> observer;
        SimpleQueue<T> queue;

        public ObserveOnObserver(Observer<? super T> observer) {
            this.observer = observer;
            queue= new SpscLinkedArrayQueue<T>(20);
        }

        @Override
        public void onNext(T t) {
            queue.offer(t);
        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onError() {

        }

        @Override
        public void run() {
            //开始循环
        }
    }
}
