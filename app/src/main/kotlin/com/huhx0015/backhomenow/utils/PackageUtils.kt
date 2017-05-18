package com.huhx0015.backhomenow.utils

import android.content.Context
import android.content.pm.PackageManager

/**
 * Created by Michael Yoon Huh on 5/17/2017.
 */

object PackageUtils {

    /** UTILITY METHODS ________________________________________________________________________  */

    // checkForAppInstall(): Checks to see if the application is installed on the device.
    fun checkForAppInstalled(packageName: String, context: Context): Boolean {

        val manager = context.packageManager

        // Checks to see if the package is installed or not.
        try {
            manager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
            return false
        }

    }
}
