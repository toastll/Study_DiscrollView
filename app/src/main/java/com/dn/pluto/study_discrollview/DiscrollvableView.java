package com.dn.pluto.study_discrollview;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * 添加滑动效果的View?【ViewGroup?】
 * Created by admin on 2016/5/28.
 */
public class DiscrollvableView extends FrameLayout  implements DiscrollvableInterface{

    public DiscrollvableView(Context context) {
        super(context);
    }

    public DiscrollvableView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //set&get方法的属性
    /**
     *  <attr name="discrollve_translation">
        <flag name="fromTop" value="0x01"/>
        <flag name="fromBottom" value="0x02"/>
        <flag name="fromLeft" value="0x04"/>
        <flag name="fromRight" value="0x08"/>
     </attr>
     */
    public static final int TRANSLATION_FROM_TOP = 0x01;
    public static final int TRANSLATION_FROM_BOTTOM = 0x02;
    public static final int TRANSLATION_FROM_LEFT = 0x04;
    public static final int TRANSLATION_FROM_RIGHT = 0x08;

    //定义一个颜色估值器
    public static ArgbEvaluator sArgbEvaluator = new ArgbEvaluator();

    /**
     * <declare-styleable name="DiscrollView_LayoutParams">
        <attr name="discrollve_alpha" format="boolean"/>
        <attr name="discrollve_scaleX" format="boolean"/>
        <attr name="discrollve_scaleY" format="boolean"/>
        <attr name="discrollve_fromBgColor" format="color"/>
        <attr name="discrollve_toBgColor" format="color"/>
        <attr name="discrollve_translation"/>
      </declare-styleable>
     */
    //自定义属性的一些接收的变量
    private boolean mDiscrollveAlpha;//是否需要透明度动画
    private boolean mDiscrollveScaleX;//是否需要X轴缩放
    private boolean mDiscrollveScaleY;//是否需要Y轴缩放
    private int mDiscrollveFromBgColor;//背景颜色变化的开始值
    private int mDiscrollveToBgColor;//背景颜色变化的结束值
    private int mDiscrollveTranslation;//平移值：该值的类型参照attrs中discrollve_translation子项的flag类型

    private int mHeight;//该View的高度
    private int mWidth;//该View的宽度

    public int getmHeight() {
        return mHeight;
    }

    public void setmHeight(int mHeight) {
        this.mHeight = mHeight;
    }

    public int getmWidth() {
        return mWidth;
    }

    public void setmWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>get方法有必要吗？
//    public boolean ismDiscrollveAlpha() {
//        return mDiscrollveAlpha;
//    }

    public void setmDiscrollveAlpha(boolean mDiscrollveAlpha) {
        this.mDiscrollveAlpha = mDiscrollveAlpha;
    }

//    public boolean ismDiscrollveScaleX() {
//        return mDiscrollveScaleX;
//    }

    public void setmDiscrollveScaleX(boolean mDiscrollveScaleX) {
        this.mDiscrollveScaleX = mDiscrollveScaleX;
    }

//    public boolean ismDiscrollveScaleY() {
//        return mDiscrollveScaleY;
//    }

    public void setmDiscrollveScaleY(boolean mDiscrollveScaleY) {
        this.mDiscrollveScaleY = mDiscrollveScaleY;
    }

//    public int getmDiscrollveFromBgColor() {
//        return mDiscrollveFromBgColor;
//    }

    public void setmDiscrollveFromBgColor(int mDiscrollveFromBgColor) {
        this.mDiscrollveFromBgColor = mDiscrollveFromBgColor;
    }

//    public int getmDiscrollveToBgColor() {
//        return mDiscrollveToBgColor;
//    }

    public void setmDiscrollveToBgColor(int mDiscrollveToBgColor) {
        this.mDiscrollveToBgColor = mDiscrollveToBgColor;
    }

//    public int getmDiscrollveTranslation() {
//        return mDiscrollveTranslation;
//    }

    public void setmDiscrollveTranslation(int mDiscrollveTranslation) {
        this.mDiscrollveTranslation = mDiscrollveTranslation;
    }


    /**
     * 当滑动的时候调用该方法，用来控制里面的控件执行相应的动画
     * @param ratio 百分比【进度？】可以看做是translationX的偏移量0~1
     */
    @Override
    public void onDiscrollve(float ratio) {

    }

    /**
     * 重置View的属性-----恢复View原来的属性
     */
    @Override
    public void onResetDiscrollve() {

    }
}
