package com.aaron.mymvp.presenter;

import com.aaron.mymvp.Contracts;
import com.aaron.mymvp.model.BaseModel;

import java.lang.ref.WeakReference;

public class BasePresenter implements Contracts.IPresenter {

    private WeakReference<Contracts.IView> mView;
    private WeakReference<Contracts.IModel> mModel;

    @Override
    public void attachView(Contracts.IView view) {
        mView = new WeakReference<>(view);
        mModel = new WeakReference<>(new BaseModel(this));
    }

    @Override
    public void detachView() {
        mView.clear();
        mModel.clear();
    }

    @Override
    public void requestText() {
        Contracts.IModel model = mModel.get();
        if (model != null) {
            model.queryText();
        }
    }

    @Override
    public void onResponse(String response) {
        Contracts.IView view = mView.get();
        if (view != null) {
            view.onShowText(response);
        }
    }
}
