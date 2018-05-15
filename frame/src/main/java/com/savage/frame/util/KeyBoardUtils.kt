package com.savage.frame.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Create by @author lin on 2018/4/25.
 * <p>
 * 功能 -> 键盘工具类，可控制软键盘的弹出和收入
 */
object KeyBoardUtils {

    var flag = true

    /**
     * 显示 Keyboard
     *
     * @param context
     */
    fun showKeyboard(context: Context) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    /**
     * 显示 Keyboard
     *
     * @param context
     * @param view    接受软键盘输入的视图
     */
    fun showKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        // 强制显示
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED)
    }

    /**
     * 隐藏软键盘
     */
    fun hideKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    /**
     * 测试软键盘的开关
     *
     * @param context
     * @param view
     */
    fun autoDisplayKeyboard(context: Context, view: View) {
        flag = if (flag) {
            showKeyboard(context)
            false
        } else {
            hideKeyboard(context, view)
            true
        }
    }

    /**
     * @param context
     * @return 输入法打开的状态，若返回 true，表示输入法打开
     */
    fun isOpen(context: Context): Boolean {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return imm.isActive
    }
}