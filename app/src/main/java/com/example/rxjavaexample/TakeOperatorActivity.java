package com.example.rxjavaexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class TakeOperatorActivity extends AppCompatActivity {

    private static final String TAG = "TakeOperatorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_operator);

        Observable.just(1, 2, 3, 4, 5, 6)
                .take(3)
                .subscribeWith(new DisposableObserver<Integer>() {
                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.e(TAG, "onNext Method call with take operator: " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete Method call with take operator " );
                    }
                });
    }
}
