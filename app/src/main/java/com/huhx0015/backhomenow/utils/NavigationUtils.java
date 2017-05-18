package com.huhx0015.backhomenow.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Michael Yoon Huh on 5/17/2017.
 */

public class NavigationUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    // launchMapsIntent(): Launches Google Maps directly in navigation mode.
    public static void launchMapsIntent(String address, Context context) {

        // Launches the customized Google Maps intent directly in navigation mode.
        Intent mapsIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + address));
        mapsIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        context.startActivity(mapsIntent);
    }
}
