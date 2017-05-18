package com.huhx0015.backhomenow.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Michael Yoon Huh on 5/17/2017.
 */

public class PackageUtils {
    
    /** UTILITY METHODS ________________________________________________________________________ **/

    // checkForAppInstall(): Checks to see if the application is installed on the device.
    private Boolean checkForAppInstalled(String packageName, Context context) {

        PackageManager manager = context.getPackageManager();

        // Checks to see if the package is installed or not.
        try {
            manager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
