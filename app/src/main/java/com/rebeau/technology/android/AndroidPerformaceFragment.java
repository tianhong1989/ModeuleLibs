package com.rebeau.technology.android;

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
import com.rebeau.technology.android.performance.kadun.KaDunActivity;
import com.rebeau.technology.android.performance.layout.LayoutActivity;
import com.rebeau.technology.android.performance.memory.MemoryActivity;
import com.rebeau.views.loading.RBLoadStatusView;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: david
 * date: 2019/4/30
 * description: ${Desc} .
 */
public class AndroidPerformaceFragment extends BaseLazyLoadFragment {

    public static AndroidPerformaceFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        AndroidPerformaceFragment fragment = new AndroidPerformaceFragment();
        fragment.setArguments(args);
        RBLogUtil.dt();
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
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_main_performance, container, false);
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
        mHandler.sendEmptyMessageDelayed(0, 300);
    }


    @OnClick(R.id.show_dialog)
    public void button(){
        MarkdownUtils.setData(mActivity, "android/performace/性能优化.MD");
    }

    @OnClick(R.id.show_dialog0)
    public void button0(){
        startActivity(new Intent(mActivity, LayoutActivity.class));
    }

    @OnClick(R.id.show_dialog1)
    public void button1(){
        startActivity(new Intent(mActivity, MemoryActivity.class));
    }


    @OnClick(R.id.show_dialog2)
    public void button2(){
        startActivity(new Intent(mActivity, KaDunActivity.class));

    }

    @OnClick(R.id.show_dialog3)
    public void button3(){
        //用来测试卡顿监听
        try {
            //Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RBLogUtil.dt("");
    }

    @OnClick(R.id.show_dialog4)
    public void button4(){

    }

    @OnClick(R.id.show_dialog5)
    public void button5(){

    }

    @OnClick(R.id.show_dialog6)
    public void button6(){

    }

    @OnClick(R.id.show_dialog7)
    public void button7(){

    }

    @OnClick(R.id.show_dialog8)
    public void button8(){

    }

    @OnClick(R.id.show_dialog9)
    public void button9(){

    }

}