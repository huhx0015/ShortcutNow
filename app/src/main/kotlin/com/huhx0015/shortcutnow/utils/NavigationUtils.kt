package com.huhx0015.shortcutnow.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by Michael Yoon Huh on 5/17/2017.
 */

object NavigationUtils {

    /** UTILITY METHODS ________________________________________________________________________  */

    // launchMapsIntent(): Launches Google Maps directly in navigation mode.
    fun launchMapsIntent(address: String, context: Context) {

        // Launches the customized Google Maps intent directly in navigation mode.
        val mapsIntent = Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + address))
        mapsIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity")
        context.startActivity(mapsIntent)
    }
}
