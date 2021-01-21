package com.example.rxjavaexample;

import android.util.Log;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TestRxJava {

    private static final String TAG = "testRxJava";

    Observable<String> animalsObservable = Observable.just("Eagle", "Bee", "Lion", "Dog", "Wolf");
    Observer<String> animalsObserver = getAnimalsObserver();

    private Observer<String> getAnimalsObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG, "onSubscribe method call");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.e(TAG, "onNext method call");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "onError method call");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete method call");
            }
        };
    }

    private void test() {
        animalsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(animalsObserver);
    }
}
