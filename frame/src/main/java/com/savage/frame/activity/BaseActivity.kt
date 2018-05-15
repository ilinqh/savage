package com.savage.frame.activity

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import com.savage.frame.util.KeyBoardUtils
import com.savage.frame.util.TipUtils

/**
 * Create by @author lin on 2018/4/25.
 * <p>
 * 功能 -> 所有 Activity 的基类
 */
abstract class BaseActivity : AppCompatActivity(), IBaseActivity {

    var mAct: BaseActivity? = null

    var savedInstanceState: Bundle? = null

    // Toolbar 类型
    private val toolbarType: ToolbarType? = null

    var toolbar: Toolbar? = null

    var textTitle: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        mAct = this
    }

    fun tip(content: String) {
        if (toolbar != null) {
            KeyBoardUtils.hideKeyboard(this, toolbar as View)
            TipUtils.snackBar(toolbar as View, content)
        } else {
            toast(content)
        }
    }

    fun toast(content: String) {
        TipUtils.toast(this, content)
    }

    /**
     * 强制转换字体，不随系统而改变
     *
     * @return
     */
    override fun getResources(): Resources {
        var res = super.getResources()
        if (res.configuration.fontScale != 1f) {
            var newConfig = Configuration()
            newConfig.setToDefaults()
            res.updateConfiguration(newConfig, res.displayMetrics)
        }
        return res
    }

}