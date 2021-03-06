package com.rebeau.technology.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rebeau.base.utils.RBLogUtil;
import com.rebeau.commons.fragment.BaseLazyLoadFragment;
import com.rebeau.commons.markdown.MarkdownUtils;
import com.rebeau.technology.R;
import com.rebeau.technology.android.performance.AndroidPerformanceTools;
import com.rebeau.technology.android.performance.apk.ApkPerformanceActivity;
import com.rebeau.technology.android.performance.kadun.KaDunActivity;
import com.rebeau.technology.android.performance.layout.LayoutActivity;
import com.rebeau.technology.android.performance.memory.MemoryActivity;
import com.rebeau.technology.android.thread.ThreadActivity;
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
        notifyLoadStatus(RBLoadStatusView.LOAD_SUCCESS);
    }

    @OnClick(R.id.read_me)
    public void readMe(){
        MarkdownUtils.setData(mActivity, "android/performace/性能优化.MD");
    }

    @OnClick(R.id.android_performace_tools)
    public void performace_tools(){
        startActivity(new Intent(mActivity, AndroidPerformanceTools.class));
    }


    @OnClick(R.id.layout_performance)
    public void layout_performance(){
        startActivity(new Intent(mActivity, LayoutActivity.class));
    }

    @OnClick(R.id.memory_performance)
    public void memory_performance(){
        startActivity(new Intent(mActivity, MemoryActivity.class));
    }


    @OnClick(R.id.show_dialog2)
    public void button2(){
        startActivity(new Intent(mActivity, KaDunActivity.class));

    }

    @OnClick(R.id.show_dialog3)
    public void start(){
        //用来测试卡顿监听

        MarkdownUtils.setData(mActivity, "android/performace/启动优化.md");
    }

    @OnClick(R.id.show_dialog4)
    public void threads(){
        startActivity(new Intent(mActivity, ThreadActivity.class));
    }

    @OnClick(R.id.show_dialog5)
    public void net(){

    }

    @OnClick(R.id.show_dialog6)
    public void diangliang(){

    }

    @OnClick(R.id.show_dialog7)
    public void apks(){

        startActivity(new Intent(mActivity, ApkPerformanceActivity.class));
    }

    @OnClick(R.id.show_dialog8)
    public void wending(){

//        先初始化Cockroach，再初始化友盟或bugly
//        https://github.com/android-notes/Cockroach

        //绕过Android P对非SDK接口限制
//        https://github.com/tiann/FreeReflection
    }

    @OnClick(R.id.show_dialog9)
    public void zhuangxiang(){

    }

}
