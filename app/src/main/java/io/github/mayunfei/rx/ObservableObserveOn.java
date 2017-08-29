package io.github.mayunfei.rx;

import android.os.Handler;
import android.os.Looper;

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
        Handler handler = new Handler(Looper.getMainLooper());

        public ObserveOnObserver(Observer<? super T> observer) {
            this.observer = observer;
//            queue= new SpscLinkedArrayQueue<T>(20);
        }

        @Override
        public void onNext(final T t) {
//            queue.offer(t);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    observer.onNext(t);
                }
            });

        }

        @Override
        public void onComplete() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    observer.onComplete();
                }
            });
        }

        @Override
        public void onError() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    observer.onError();
                }
            });
        }

        @Override
        public void run() {
            //开始循环
        }
    }
}
