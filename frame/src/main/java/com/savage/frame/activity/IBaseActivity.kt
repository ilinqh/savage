package com.savage.frame.activity

import android.annotation.SuppressLint
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes

/**
 * Create by @author lin on 2018/5/7.
 * <p>
 * 功能 ->
 */
interface IBaseActivity {

    companion object {

        @SuppressLint("ResourceType")
        @StringRes
        @LayoutRes
        const val NO_CONTENT = -1

        @SuppressLint("ResourceType")
        @StringRes
        @LayoutRes
        const val NO_TITLE = -2
    }

    /**
     * 获取 Activity 资源文件 ID
     */
    @LayoutRes
    fun getContentResId(): Int

    /**
     * 获取 Activity 标题资源文件 ID
     */
    @StringRes
    fun getTitleResId(): Int

    /**
     * 获取toolbar ID
     */
    @IdRes
    fun getToolBarId(): Int

    /**
     * 获取标题的 TextView id
     *
     * @return
     */
    @IdRes
    fun getTitleTextViewResId(): Int

    /**
     * 初始化页面
     */
    fun initView()

    /**
     * 请求数据
     */
    fun requestData()

    /**
     * 设置 Activity 布局方式，是否全屏、是否有标题栏
     */
//    fun getToolbarType(): ToolbarType
}