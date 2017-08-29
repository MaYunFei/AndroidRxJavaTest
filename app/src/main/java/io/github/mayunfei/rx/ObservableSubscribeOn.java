package io.github.mayunfei.rx;

/**
 * Created by mayunfei on 17-8-29.
 */

public class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T,T> {

    public ObservableSubscribeOn(Observable<T> source) {
        super(source);
    }

    @Override
    protected void subscribeActual(final Observer<? super T> observer) {
        SubscribeOnObserver parent = new SubscribeOnObserver(observer); //可取消的
        Thread thread = new Thread(new Task(parent),"io thread");
        thread.run();
    }

    class Task implements Runnable{
        Observer<? super T>  observer;

        public Task(Observer<? super T>  observer) {
            this.observer = observer;
        }

        @Override
        public void run() {
            source.subscribe(observer);
        }
    }
    class SubscribeOnObserver implements Observer<T>{
        Observer<? super T> source;

        public SubscribeOnObserver(Observer<? super T> source) {
            this.source = source;
        }

        @Override
        public void onNext(T t) {
            source.onNext(t);
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
