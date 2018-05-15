package com.savage.frame.util

import android.content.Context
import android.support.design.widget.BaseTransientBottomBar
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

/**
 * Create by @author lin on 2018/4/25.
 * <p>
 * 功能 ->提供两种提示方式
 * 第一种是 toast，封装了常用的 Toast 方法
 * 第二种是 Android 5.0 新增的 snackBar 提示
 */
object TipUtils {

    private var mToast: Toast? = null

    /**
     * 进行 Toast 提示
     *
     * @param context
     * @param content
     */
    fun toast(context: Context, content: String) {
        if (null == mToast) {
            mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT)
        } else {
            mToast?.setText(content)
        }
        mToast?.show()
    }

    /**
     * 进行 SnackBar 提示，并提供点击按钮，前提是实现 onClickListener
     *
     * @param view
     * @param content
     */
    fun snackBar(view: View, content: String) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).show()
    }

    fun snackBar(view: View, content: String, action: String, listener: View.OnClickListener) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).setAction(action, listener).show()
    }

}