package com.dn.pluto.study_discrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * Created by admin on 2016/5/28.
 */
public class DiscrollView extends ScrollView {

    /**
     * 用来显示DiscrollView下所有控件的ViewGroup
     */
    private DiscrollViewContent mContent;

    public DiscrollView(Context context) {
        super(context);
    }

    public DiscrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 当布局解析完成之后调用该方法
     * inflate【渲染布局？】
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //获取该ScrollView下的下标为0的子布局，即ScrollViewContent
        //getChildAt(int index)方法为ViewGroup下的方法，用来根据下标获取指定的子控件【或布局】
        View content =  getChildAt(0);
        mContent = (DiscrollViewContent)content;
    }

    /**
     * 当滑动改变时回调该方法
     * @param l
     * @param t
     * @param oldl
     * @param oldt
     */
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        //监听滑动----接口------>控制DiscrollViewContent【即ViewGroup】的属性
        for(int i=0; i<mContent.getChildCount(); i++){//遍历MyLinearLayout【DiscrollViewContent】里面所有的子控件（MyViewGroup）
//            View child = mContent.getChildAt(i);//DiscrollViewContent下的子控件【错误1 todo】
            View child = mContent.getChildAt(i);//DiscrollViewContent下的ViewGroup

            //ratio: 0~1   将ratio传入到哪里呢？
            //将ratio传入到DiscrollvableView中， todo
            //实现方法：让DiscrollvableView实现接口DiscrollvableInterface
//            DiscrollvableView discrollvableView = (DiscrollvableView)child;//首次 todo
            DiscrollvableInterface discrollvableInterface = (DiscrollvableInterface) child;//修改后
            discrollvableInterface.onDiscrollve(ratio);//传入ratio 百分比
        }
    }
}
