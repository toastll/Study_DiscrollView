package com.dn.pluto.study_discrollview;

/**
 * 控制View需要的接口
 * Created by admin on 2016/5/28.
 */
public interface DiscrollvableInterface {

    /**
     * 当滑动的时候调用该方法，用来控制里面的控件执行相应的动画
     * @param ratio 百分比【进度？】可以看做是translationX的偏移量0~1
     */
    public void onDiscrollve(float ratio);

    /**
     * 重置View的属性-----恢复View原来的属性
     */
    public void onResetDiscrollve();
}
