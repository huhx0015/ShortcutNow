package com.huhx0015.backhomenow

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

/** ------------------------------------------------------------------------------------------------
 *  [MainActivity] CLASS
 *  DEVELOPER: Huh X0015
 *  DESCRIPTION: This class is the main activity for the application. The user can create a custom
 *  location shortcut that launches Google Maps and begins navigation mode immediately.
 *  ------------------------------------------------------------------------------------------------
 */

class MainActivity : AppCompatActivity() {

    /** ACTIVITY LIFECYCLE FUNCTIONALITY _______________________________________________________ **/

    // onCreate(): The initial function that is called when the activity is run. onCreate() only runs
    // when the activity is first started.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
