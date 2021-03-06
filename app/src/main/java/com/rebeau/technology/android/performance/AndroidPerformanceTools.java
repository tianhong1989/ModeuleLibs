package com.rebeau.technology.android.performance;

import android.app.Activity;
import android.os.Bundle;

import com.rebeau.commons.markdown.MarkdownUtils;
import com.rebeau.technology.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AndroidPerformanceTools extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_performance_tools);
        ButterKnife.bind(this);
    }



    @OnClick(R.id.performance_ku)
    public void performance_ku(){
        MarkdownUtils.setData(this, "android/performace/性能优化相关库.md");
    }

    @OnClick(R.id.leakcanary)
    public void leakcanary(){
        //MarkdownUtils.setData(this, "android/performace/性能优化相关库.md");
    }

    @OnClick(R.id.lint)
    public void lint(){
        //MarkdownUtils.setData(this, "android/performace/性能优化相关库.md");
    }

    @OnClick(R.id.show_dialog)
    public void show_dialog(){

        MarkdownUtils.setData(this, "android/performace/ram/android_prifile_cup.MD");
    }

    @OnClick(R.id.android_performace_tools)
    public void android_profile_cpu(){
        MarkdownUtils.setData(this, "android/performace/ram/android_prifile_memory.MD");
    }

    @OnClick(R.id.show_dialog0)
    public void systrace(){
        MarkdownUtils.setData(this, "android/performace/systrace.MD");
    }


    @OnClick(R.id.show_dialog1)
    public void show_dialog1(){
        MarkdownUtils.setData(this, "android/performace/MAT.MD");

    }
}
