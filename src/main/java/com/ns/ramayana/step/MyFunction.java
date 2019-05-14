package com.ns.ramayana.step;

import com.ns.ramayana.view.WelcomeView;

import java.util.function.Function;

public interface MyFunction<T, R> extends Function<T, R>{

    default Void apply(Void v) {
        apply();
        return null;
    }
    void apply();

}
