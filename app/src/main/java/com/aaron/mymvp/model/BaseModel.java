package com.aaron.mymvp.model;

import com.aaron.mymvp.Contracts;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BaseModel implements Contracts.IModel {

    private static final String TAG = "BaseModel";
    private static final String[] CONTENT = {"Java", "Android", "OkHttp", "Retrofit",
            "ButterKnife", "Glide", "Picasso"};
    private Contracts.IPresenter mPresenter;
    private ExecutorService mExecutorService;
    private Random mRandom;

    public BaseModel(Contracts.IPresenter presenter) {
        mPresenter = presenter;
        mExecutorService = Executors.newSingleThreadExecutor();
        mRandom = new Random();
    }

    @Override
    public void queryText() {
        mExecutorService.execute(() -> {
            try {
                Thread.sleep(100);
                if (mPresenter != null) {
                    mPresenter.onResponse(CONTENT[getRandomIndex()]);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private int getRandomIndex() {
        return mRandom.nextInt(CONTENT.length);
    }
}
