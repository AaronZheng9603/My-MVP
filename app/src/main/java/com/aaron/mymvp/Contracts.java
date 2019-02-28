package com.aaron.mymvp;

public interface Contracts {

    interface IView {

        void onShowText(String text);
    }

    interface IPresenter {

        void attachView(IView view);

        void detachView();

        void requestText();

        void onResponse(String response);
    }

    interface IModel {

        void queryText();
    }
}
