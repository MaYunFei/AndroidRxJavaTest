package io.github.mayunfei.rx;

/**
 * Created by mayunfei on 17-8-29.
 */

public interface Function<T, R> {
    R apply(T t);
}
