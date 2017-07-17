package io.github.mayunfei.network;

/**
 * Created by mayunfei on 17-7-17.
 */

public class BaseResult<T> {
    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
