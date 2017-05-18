package com.huhx0015.shortcutnow.utils

import android.support.design.widget.Snackbar
import android.view.View

/**
 * Created by Michael Yoon Huh on 5/17/2017.
 */

object SnackbarUtils {

    /** UTILITY METHODS ________________________________________________________________________  */

    fun displaySnackbar(view: View, message: String, length: Int, color: Int) {
        val snackbar = Snackbar.make(view, message, length)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(color)
        snackbar.show()
    }

    fun displaySnackbarWithAction(view: View, message: String, length: Int, color: Int,
                                  action: String, listener: View.OnClickListener) {
        val snackbar = Snackbar.make(view, message, length)
                .setAction(action, listener)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(color)
        snackbar.show()
    }
}
