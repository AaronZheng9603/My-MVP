package com.aaron.mymvp.view;

import android.os.Bundle;
import android.widget.TextView;

import com.aaron.mymvp.Contracts;
import com.aaron.mymvp.R;
import com.aaron.mymvp.presenter.BasePresenter;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Contracts.IView {

    private static final String TAG = "MainActivity";

    @BindView(R.id.text_view)
    TextView mTextView;
    private Contracts.IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new BasePresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onShowText(String text) {
        mTextView.setText(text);
    }

    @OnClick(R.id.button)
    void requestText() {
        mPresenter.requestText();
    }
}
