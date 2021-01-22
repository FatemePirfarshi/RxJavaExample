package com.example.rxjavaexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RxJavaExample";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> animalObservale = getAnimalsObservable();
        Observer<String> animalObserver = getAnimalsObserver();

        animalObservale.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(animalObserver);
    }

    private Observable<String> getAnimalsObservable(){
        return Observable.just("Eagle", "Bea", "Lion", "Dog", "Wolf");
    }

    private Observer<String> getAnimalsObserver(){
        return new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG, "onSubscribe method call");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.e(TAG, "onNext method call" + s);
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

}
