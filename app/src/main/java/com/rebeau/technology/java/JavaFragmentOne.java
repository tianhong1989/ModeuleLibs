package com.rebeau.technology.java;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebeau.base.utils.RBLogUtil;
import com.rebeau.commons.fragment.BaseLazyLoadFragment;
import com.rebeau.commons.markdown.MarkdownUtils;
import com.rebeau.technology.R;
import com.rebeau.technology.android.rxjava.HomeActivity;
import com.rebeau.technology.java.testdesignmodel.DesignModelActivity;
import com.rebeau.views.loading.RBLoadStatusView;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: david
 * date: 2019/4/30
 * description: ${Desc} .
 */
public class JavaFragmentOne extends BaseLazyLoadFragment {

    public static JavaFragmentOne newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        JavaFragmentOne fragment = new JavaFragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    private String mType;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            RBLogUtil.dt();
            notifyLoadStatus(RBLoadStatusView.LOAD_SUCCESS);
        }
    };

    @Override
    protected View createSuccessView(@Nullable ViewGroup container) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.java_fragment_one, container, false);
        ButterKnife.bind(this, view);

        RBLogUtil.dt();
        if (getArguments() != null) {
            mType = getArguments().getString("type");
        }
        return view;
    }


    @Override
    protected boolean haveLazyData() {
        RBLogUtil.dt();
        return isLazyLoad;
    }

    @Override
    protected void onLoadData() {
        RBLogUtil.dt();
        isLazyLoad = true;
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    @OnClick(R.id.java_fragment_lamada)
    public void ladamda(){
        MarkdownUtils.setData(mActivity, "lamada/LAMADA.MD");
    }

    @OnClick(R.id.java_fragment_rxjava)
    public void rxjava(){
        startActivity(new Intent(mActivity, HomeActivity.class));
    }

    @OnClick(R.id.java_fragment_designmodel)
    public void designmmd(){
        startActivity(new Intent(mActivity, DesignModelActivity.class));
    }
}