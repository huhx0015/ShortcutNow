package com.huhx0015.backhomenow.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.huhx0015.backhomenow.listeners.ShortcutListener

/**
 * Created by Michael Yoon Huh on 5/17/2017.
 */

object ShortcutUtils {

    /** UTILITY METHODS ________________________________________________________________________  */

    // setShortcut(): Sets up the intent for Google Maps and creates the shortcuts on the user's
    // homescreen.
    fun setShortcut(shortcutName: String, address: String, resource: Int, context: Context,
                    listener: ShortcutListener) {

        // Creates an intent for the shortcut, which launches Google Map in navigation mode and
        // begins navigation immediately.
        val shortcutIntent = Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + address))
        shortcutIntent.action = Intent.ACTION_VIEW

        // Creates an intent for adding the shortcut to the device's homescreen.
        val addIntent = Intent()
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent)
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName)

        // Sets the icon resource for the shortcut.
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(context.applicationContext,
                        resource))

        // Adds the shortcut on the device's homescreen.
        addIntent.action = "com.android.launcher.action.INSTALL_SHORTCUT"
        context.applicationContext.sendBroadcast(addIntent)

        // Listener method invoked to signal that the shortcut has been added.
        listener.onShortcutAdded()
    }
}
