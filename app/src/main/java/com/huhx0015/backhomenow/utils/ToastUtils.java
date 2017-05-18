package com.huhx0015.backhomenow.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Michael Yoon Huh on 5/17/2017.
 */

public class ToastUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    // displayToast(): Creates and displays a Toast message.
    public static void displayToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
