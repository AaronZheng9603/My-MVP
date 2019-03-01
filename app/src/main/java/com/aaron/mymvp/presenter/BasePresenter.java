package com.aaron.mymvp.presenter;

import com.aaron.mymvp.Contracts;
import com.aaron.mymvp.model.BaseModel;

public class BasePresenter implements Contracts.IPresenter {

    private static final String TAG = "BasePresenter";

    private Contracts.IView mView;
    private Contracts.IModel mModel;

    @Override
    public void attachView(Contracts.IView view) {
        mView = view;
        mModel = new BaseModel(this);
    }

    @Override
    public void detachView() {
        mView = null;
        mModel = null;
    }

    @Override
    public void requestText() {
        if (mModel != null) {
            mModel.queryText();
        }
    }

    @Override
    public void onResponse(String response) {
        if (mView != null) {
            mView.onShowText(response);
        }
    }
}
