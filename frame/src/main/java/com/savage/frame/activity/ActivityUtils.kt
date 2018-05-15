package com.savage.frame.activity

import android.content.pm.ActivityInfo
import android.support.v7.widget.Toolbar
import android.view.WindowManager
import android.widget.TextView

/**
 * Create by @author lin on 2018/4/25.
 * <p>
 * 功能 -> activity 工具类
 */
class ActivityUtils {

    fun initActivity(activity: BaseActivity, toolbarType: ToolbarType) {
        when (toolbarType) {
            ToolbarType.FullScreen -> {
                initFullScreen(activity)
                initNoToolbar(activity)
            }
            ToolbarType.NoToolbar -> initNoToolbar(activity)
            ToolbarType.Default -> initDefault(activity)
        }
    }


    /**
     * 全屏/没有状态栏、工具栏
     *
     * @param activity
     */
    private fun initFullScreen(activity: BaseActivity) {
        activity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams
                .FLAG_FULLSCREEN)
    }

    /**
     * 没有工具栏，但有状态栏
     *
     * @param activity
     */
    private fun initNoToolbar(activity: BaseActivity) {
        // 设置布局文件
        initContent(activity)
    }

    /**
     * 既有工具栏，又有状态栏
     *
     * @param activity
     */
    private fun initDefault(activity: BaseActivity) {
        // 设置布局文件
        initContent(activity)
        // 设置 Title
        initTitle(activity)
    }

    /**
     * 设置 Title
     *
     * @param activity
     */
    private fun initTitle(activity: BaseActivity) {
        // 设置 Toolbar
        val toolbar = activity.findViewById<Toolbar>(activity.getToolBarId())
        activity.toolbar = toolbar
        activity.setSupportActionBar(toolbar)

        // 设置 toolbar 显示的 Title 文字
        val textTitle = toolbar.findViewById<TextView>(activity.getTitleTextViewResId())
        activity.textTitle = textTitle
        if (activity.getTitleResId() != IBaseActivity.NO_TITLE && textTitle != null) {
            // 设置 Title
            textTitle.text = activity.resources.getString(activity.getTitleResId())
        }
    }

    /**
     * 初始化 Activity 的主视图
     *
     * @param activity
     */
    private fun initContent(activity: BaseActivity) {
        //  设置为竖屏
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        if (IBaseActivity.NO_CONTENT !== activity.getContentResId()) {
            activity.setContentView(activity.getContentResId())
        }
    }
}