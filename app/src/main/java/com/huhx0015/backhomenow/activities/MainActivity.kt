package com.huhx0015.backhomenow.activities

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatImageButton
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import com.huhx0015.backhomenow.R
import com.huhx0015.backhomenow.listeners.ShortcutListener
import com.huhx0015.backhomenow.utils.NavigationUtils
import com.huhx0015.backhomenow.utils.PackageUtils
import com.huhx0015.backhomenow.utils.ShortcutUtils
import com.huhx0015.backhomenow.utils.SnackbarUtils

/** ------------------------------------------------------------------------------------------------
 *  [MainActivity] CLASS
 *  DEVELOPER: Huh X0015
 *  DESCRIPTION: This class is the main activity for the application. The user can create a custom
 *  location shortcut that launches Google Maps and begins navigation mode immediately.
 *  ------------------------------------------------------------------------------------------------
 */

class MainActivity : AppCompatActivity() {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // ADDRESS VARIABLES:
    private var mAddress: String = ""
    private var mLocationName: String = ""

    // LAYOUT VARIABLES:
    private var mActivityLayout: CoordinatorLayout? = null

    // PACKAGE VARIABLES:
    companion object {
        private val PACKAGE_GOOGLE_MAPS = "com.google.android.apps.maps"
    }

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________ **/

    // onCreate(): The initial function that is called when the activity is run. onCreate() only runs
    // when the activity is first started.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mActivityLayout = findViewById(R.id.main_activity_layout) as CoordinatorLayout
        initView()
    }

    /** INIT METHODS ___________________________________________________________________________ **/

    private fun initView() {
        initButtons()
        initInputFields()
        initToolbar()
    }

    private fun initButtons() {

        val shortcutListener = object : ShortcutListener {
            override fun onShortcutAdded() {
                SnackbarUtils.displaySnackbar(mActivityLayout!!,
                        getString(R.string.success_shortcut_created),
                        Snackbar.LENGTH_SHORT,
                        ContextCompat.getColor(this@MainActivity, R.color.colorAccent))
            }
        }

        // SHORTCUT HOME BUTTON:
        val shortcutHomeButton = findViewById(R.id.main_home_button) as AppCompatImageButton
        shortcutHomeButton.setOnClickListener {
            if (!mAddress.isBlank() && !mLocationName.isBlank()) {
                ShortcutUtils.setShortcut(mLocationName, mAddress, R.drawable.ic_home_black_48dp,
                        this, shortcutListener)
            } else {
                SnackbarUtils.displaySnackbar(mActivityLayout!!,
                        getString(R.string.error_field_input), Snackbar.LENGTH_SHORT,
                        ContextCompat.getColor(this, R.color.colorError))
            }
        }

        // SHORTCUT WORK BUTTON:
        val shortcutWorkButton = findViewById(R.id.main_work_button) as AppCompatImageButton
        shortcutWorkButton.setOnClickListener {
            if (!mAddress.isBlank() && !mLocationName.isBlank()) {
                ShortcutUtils.setShortcut(mLocationName, mAddress, R.drawable.ic_work_black_48dp,
                        this, shortcutListener)
            } else {
                SnackbarUtils.displaySnackbar(mActivityLayout!!,
                        getString(R.string.error_field_input), Snackbar.LENGTH_SHORT,
                        ContextCompat.getColor(this, R.color.colorError))
            }
        }

        // SHORTCUT PLACE BUTTON:
        val shortcutPlaceButton = findViewById(R.id.main_place_button) as AppCompatImageButton
        shortcutPlaceButton.setOnClickListener {
            if (!mAddress.isBlank() && !mLocationName.isBlank()) {
                ShortcutUtils.setShortcut(mLocationName, mAddress, R.drawable.ic_location_on_black_48dp,
                        this, shortcutListener)
            } else {
                SnackbarUtils.displaySnackbar(mActivityLayout!!,
                        getString(R.string.error_field_input), Snackbar.LENGTH_SHORT,
                        ContextCompat.getColor(this, R.color.colorError))
            }
        }

        // NAVIGATION BUTTON:
        val navigationButton = findViewById(R.id.main_navigation_button) as AppCompatButton
        navigationButton.setOnClickListener {
            if (PackageUtils.checkForAppInstalled(PACKAGE_GOOGLE_MAPS, this)) {
                NavigationUtils.launchMapsIntent(mAddress, this)
            } else {
                SnackbarUtils.displaySnackbar(mActivityLayout!!,
                        getString(R.string.error_google_maps), Snackbar.LENGTH_SHORT,
                        ContextCompat.getColor(this, R.color.colorError))
            }
        }
    }

    private fun initInputFields() {

        // LOCATION NAME FIELD:
        val locationNameField = findViewById(R.id.main_location_field) as TextInputEditText
        locationNameField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                mLocationName = locationNameField.text.toString()
            }

            override fun afterTextChanged(s: Editable) {}
        })

        // ADDRESS FIELD:
        val addressField = findViewById(R.id.main_address_field) as TextInputEditText
        addressField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                mAddress = locationNameField.text.toString()
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun initToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }
}
