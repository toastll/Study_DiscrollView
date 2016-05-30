package com.dn.pluto.study_discrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * LinearLayout即scrollView的滑动块
 * Created by admin on 2016/5/28.
 */
public class DiscrollViewContent extends LinearLayout {


    public DiscrollViewContent(Context context) {
        super(context);
    }

    public DiscrollViewContent(Context context, AttributeSet attrs) {
        super(context, attrs);

        //测试
//        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.DiscrollView_LayoutParams);
//        String ss = typedArray.getString(R.styleable.DiscrollView_LayoutParams_test);
//        Log.d("TAG", "DiscrollViewContent: "+ss);
    }


    /**
     * 每一个ViewGroup放置子控件的方法，都是通过调用addView方法来实现的!!1 todo
     *
     * @param child  the child view to add【用来添加的childView】
     * @param index  the position at which to add the child or -1 to add last
     *               【the position at which to add the child在哪个位置添加这个child】
     * @param params the layout parameters to set on the child【childView的参数集合 todo】
     */
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        //在addView里面插一脚，往child的外面包裹一层FrameLayout

        //1.new 一个用来包裹child的布局discrollvableView
        DiscrollvableView discrollvableView = new DiscrollvableView(getContext());
        //2.将child中的属性放入到他的父容器discrollvableView中【如discrollve_alpha="true"等属性】
        //  从child里面拿到自定义的属性，并传入到discrollvableView里面


        discrollvableView.setmDiscrollveAlpha(mDiscrollveAlpha);


        //3.包裹child
        discrollvableView.addView(child);

        //finally: 调用addView将discrollvableView加入当前的布局中
        super.addView(discrollvableView, index, params);
//        super.addView(child, index, params);//变更原有的参数
    }

    /**
     * ViewGroup在实例化的时候会不断的调用该方法，以便从子控件中获取到属于该父容器的属性
     * generate 生成
     * 所有的ViewGroup在生成LayoutParams时，都会调用该方法，
     *
     * @param attrs ViewGroup下子控件里面的属性
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        //得到xml里面传过来的参数

        return new MyLayoutParams(getContext(), attrs);
        //为什么要这么玩？这么玩有什么好处？
        //todo  目的:从child里面拿到自定义的属性
//        return super.generateLayoutParams(attrs);
    }

    /**
     * 自定义LayoutParams用来替换LinearLayout.LayoutParams
     * 思考：为什么要自定义LayoutParams?这个LayoutParams又有什么用呢？
     */
    public static class MyLayoutParams extends LinearLayout.LayoutParams {

        private boolean mDiscrollveAlpha;//是否需要透明度动画
        private boolean mDiscrollveScaleX;//是否需要X轴缩放
        private boolean mDiscrollveScaleY;//是否需要Y轴缩放
        private int mDiscrollveFromBgColor;//背景颜色变化的开始值
        private int mDiscrollveToBgColor;//背景颜色变化的结束值
        private int mDiscrollveTranslation;//平移值：该值的类型参照attrs中discrollve_translation子项的flag类型


        //【疑问】这个attrs是子控件中的属性？
        public MyLayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            //【疑问】目的:从child里面拿到自定义的属性
            //参数1 ？  参数2：为styleable下所有的自定义属性  return:TypedArray
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DiscrollView_LayoutParams);
            //参数1：styleable下的attr名，   参数2：该attr的默认值
            mDiscrollveAlpha = typedArray.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_alpha, false);
            mDiscrollveScaleX = typedArray.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_scaleX, false);
            mDiscrollveScaleY = typedArray.getBoolean(R.styleable.DiscrollView_LayoutParams_discrollve_scaleY, false);
            //【思考】为什么默认值要设定为-1？有什么特殊含义？这是一个细节问题！！todo
            mDiscrollveTranslation = typedArray.getInt(R.styleable.DiscrollView_LayoutParams_discrollve_translation,-1);
            mDiscrollveFromBgColor = typedArray.getInt(R.styleable.DiscrollView_LayoutParams_discrollve_fromBgColor,-1);
            mDiscrollveToBgColor = typedArray.getInt(R.styleable.DiscrollView_LayoutParams_discrollve_toBgColor,-1);
        }
    }

    //addView的重载方法很多，具体使用哪一个 根据自己的需求来定
    //    @Override
//    public void addView(View child) {
//        super.addView(child);
//    }
}
