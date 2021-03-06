package com.rebeau.technology.android.jichu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rebeau.commons.activity.BaseFragmentActivity;
import com.rebeau.commons.markdown.MarkdownUtils;
import com.rebeau.technology.R;
import com.rebeau.views.loading.RBLoadStatusView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConstraintLayoutActivity extends BaseFragmentActivity {

    @BindView(R.id.line1e_imageview)
    ImageView line1e_imageview;

    @BindView(R.id.line1e_text)
    TextView line1e_text;

    @Override
    protected View createSuccessView() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_constraint_layout, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected String getTitleBarName() {
        return "ConstraintLayout";
    }

    @Override
    protected void onLoadData() {

        notifyLoadStatus(RBLoadStatusView.LOAD_SUCCESS);
    }

    @OnClick(R.id.bt_4)
    public void bt_4(){
        MarkdownUtils.setData(mActivity, "android/yuanli/constraintlayout.md");
    }

    @OnClick(R.id.line1e_imageview)
    public void line1e_imageview(){
        // 创建一个 SpannableString对象，
        // SpannableString implements GetChars,Spannable,CharSequence
        SpannableString msp = new SpannableString("字体字体字体大小一半两倍前景色背景色正常粗体斜体粗斜体下划线删除线x1x2，电话，邮件，网站，短信，彩信，地图，X轴综合");

        // setSpan会将start到end这间的文本设置成创建的span格式。span可以是图片格式。
        // 设置字体(default,default-bold,monospace,serif,sans-serif)
        msp.setSpan(new TypefaceSpan("monospace"), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 等宽字体
        msp.setSpan(new TypefaceSpan("serif"), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 衬线字体

        // 设置字体绝对大小（绝对值,单位：像素）
        msp.setSpan(new AbsoluteSizeSpan(20), 4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 第二个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素，同上。
        msp.setSpan(new AbsoluteSizeSpan(20, true), 6, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // 设置字体相对大小（相对值,单位：像素） 参数表示为默认字体大小的多少倍
        msp.setSpan(new RelativeSizeSpan(0.5f), 8, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 0.5f表示默认字体大小的一半
        msp.setSpan(new RelativeSizeSpan(2.0f), 10, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 2.0f表示默认字体大小的两倍

        // 设置字体前景色 ，Color.MAGENTA为紫红
        msp.setSpan(new ForegroundColorSpan(Color.MAGENTA), 12, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置前景色为洋红色
        // 设置字体背景色 ，Color.CYAN为青绿色
        msp.setSpan(new BackgroundColorSpan(Color.CYAN), 15, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置背景色为青色

        // 设置字体样式正常，粗体，斜体，粗斜体
        msp.setSpan(new StyleSpan(android.graphics.Typeface.NORMAL), 18, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 正常
        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 20, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 粗体
        msp.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 22, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 斜体
        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 24, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 粗斜体

        // 设置下划线
        msp.setSpan(new UnderlineSpan(), 27, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置字体前景色, 建议放在最后
        msp.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_ff4242)), 27, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 添加点击事件, 这个时候设置的字体颜色就会失效了，所以这个时候字体颜色设置要放在后面， 这样就可以了
        msp.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(ConstraintLayoutActivity.this, "设置下划线的点击", Toast.LENGTH_LONG).show();
            }
        }, 27, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置字体前景色
        msp.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_ff4242)), 27, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // 设置删除线
        msp.setSpan(new StrikethroughSpan(), 30, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // 设置上下标
        msp.setSpan(new SubscriptSpan(), 34, 35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 下标
        msp.setSpan(new SuperscriptSpan(), 36, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 上标

        // 超级链接（需要添加setMovementMethod方法附加响应）
        msp.setSpan(new URLSpan("tel:4155551212"), 38, 40, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 电话
        msp.setSpan(new URLSpan("mailto:webmaster@google.com"), 41, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 邮件
        msp.setSpan(new URLSpan("http://www.baidu.com"), 44, 46, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 网络
        msp.setSpan(new URLSpan("sms:4155551212"), 47, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 短信，使用sms:或者smsto:
        msp.setSpan(new URLSpan("mms:4155551212"), 50, 52, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 彩信，使用mms:或者mmsto:
        msp.setSpan(new URLSpan("geo:38.899533,-77.036476"), 53, 55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 地图

        line1e_text.setLinkTextColor(getResources().getColor(R.color.color_ff4242));

        // 设置字体大小（相对值,单位：像素） 参数表示为默认字体宽度的多少倍
        msp.setSpan(new ScaleXSpan(2.0f), 57, 59, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 2.0f表示默认字体宽度的两倍，即X轴方向放大为默认字体的两倍，而高度不变
        line1e_text.setText(msp);

        // 超级链接响应, 否则，上面设置的URLspan都是无效的
        line1e_text.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
