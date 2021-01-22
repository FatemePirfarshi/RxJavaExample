package com.example.rxjavaexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class FilterOperatorActivity extends AppCompatActivity {

    private static final String TAG = "FilterOperatorActivity";

    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_operator);

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Throwable {
                        return integer % 2 == 0;
                    }
                }).subscribe(new DisposableObserver<Integer>() {
            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG, "onNext Method Call -> "+"Even: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete Method Call at the end of stream");
            }
        });
    }

    protected void onDestroy() {
        disposable.clear();
        super.onDestroy();
    }
}
