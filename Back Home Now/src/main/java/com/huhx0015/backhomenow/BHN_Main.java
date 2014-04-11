package com.huhx0015.backhomenow;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/** ------------------------------------------------------------------------------------------------
 *  [BHN_Main] CLASS
 *  PROGRAMMER: Michael Yoon Huh (HUHX0015)
 *  DESCRIPTION: This class is the main activity for the application. The user can create a custom
 *  location shortcut that launches Google Maps and begins navigation mode immediately.
 *  ------------------------------------------------------------------------------------------------
 */

public class BHN_Main extends Activity {

    /** ACTIVITY LIFECYCLE FUNCTIONALITY _______________________________________________________ **/

    // onCreate(): The initial function that is called when the activity is run. onCreate() only runs
    // when the activity is first started.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bhn_main); // Assigns the layout for the activity.
        setUpButtons(); // Sets up the button listeners for the activity.
    }

    /** ADDITIONAL FUNCTIONALITY _______________________________________________________________ **/

    // checkForAppInstall(): Checks to see if the application is installed on the device.
    private Boolean checkForAppInstalled(String packName) {

        PackageManager pm = getPackageManager();
        boolean isInstalled = false;

        // Checks to see if the package is installed or not.
        try {
            pm.getPackageInfo(packName, PackageManager.GET_ACTIVITIES);
            isInstalled = true;
        }

        // NameNotFoundException handler.
        catch (PackageManager.NameNotFoundException e) {
            isInstalled = false;
        }

        return isInstalled;
    }

    // launchIntent(): Launches Google Maps directly in navigation mode.
    private void launchIntent() {

        // Assigns the EditText reference to the address input.
        EditText address_1 = (EditText)findViewById(R.id.address_input_1);

        // Retrieves the address from the user's input.
        String location = address_1.getText().toString();
        location = location.replace(" ", "+");

        // Launches the customized Google Maps intent directly in navigation mode.
        Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + location));
        i.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(i);
    }

    // setShortcut(): Sets up the intent for Google Maps and creates the shortcuts on the user's
    // homescreen.
    private void setShortcut(int mode) {

        // Sets the reference to the address input.
        EditText address_1 = (EditText) findViewById (R.id.address_input_1);

        // Retrieves the address in the input string.
        String location = address_1.getText().toString();
        location = location.replace(" ", "+");

        // Launches Google Map in navigation mode and begins navigation immediately.
        Intent shortcutIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + location));
        shortcutIntent.setAction(Intent.ACTION_VIEW);

        // Adds the address in the customized intent for Google Maps.
        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, address_1.getText().toString());

        int iconResource = R.drawable.home_icon; // Used for setting the shortcut icon resource.

        // Sets the icon based on the selected mode.
        switch (mode) {

            // HOME:
            case 0:
                iconResource = R.drawable.home_icon;
                break;

            // WORK:
            case 1:
                iconResource = R.drawable.work_icon;
                break;

            // PLACE:
            case 2:
                iconResource = R.drawable.place_icon;
                break;
        }

        // Sets the icon resource for the shortcut.
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                iconResource));

        // Installs the shortcut on the homescreen.
        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        getApplicationContext().sendBroadcast(addIntent);
    }

    // setUpButtons(): Sets up the button listeners for the activity.
    private void setUpButtons() {

        // Assigns references to the ImageButton objects.
        ImageButton home_button = (ImageButton) findViewById(R.id.home_button);
        ImageButton work_button = (ImageButton) findViewById(R.id.work_button);
        ImageButton place_button = (ImageButton) findViewById(R.id.place_button);
        Button google_button = (Button) findViewById(R.id.google_button);

        // HOME Button:
        home_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Checks to see if Google Maps is installed first.
                if ( !(checkForAppInstalled("com.google.android.apps.maps")) ) {
                    toastyPopUp(); // Displays a Toast popup.
                }

                // Otherwise, the shortcut is created.
                else {
                    setShortcut(0); // Sets the "HOME" shortcut on the homescreen.
                }
            }
        });

        // WORK Button:
        work_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Checks to see if Google Maps is installed first.
                if ( !(checkForAppInstalled("com.google.android.apps.maps")) ) {
                    toastyPopUp(); // Displays a Toast popup.
                }

                // Otherwise, the shortcut is created.
                else {
                    setShortcut(1); // Sets the "WORK" shortcut on the homescreen.
                }
            }
        });

        // PLACE Button:
        place_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Checks to see if Google Maps is installed first.
                if ( !(checkForAppInstalled("com.google.android.apps.maps")) ) {
                    toastyPopUp(); // Displays a Toast popup.
                }

                // Otherwise, the shortcut is created.
                else {
                    setShortcut(2); // Sets the "PLACE" shortcut on the homescreen.
                }
            }
        });

        // GOOGLE MAPS Button:
        google_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Checks to see if Google Maps is installed first.
                if ( !(checkForAppInstalled("com.google.android.apps.maps")) ) {
                    toastyPopUp(); // Displays a Toast popup.
                }

                // Otherwise, the shortcut is created.
                else {
                    launchIntent(); // Launches the Google Maps intent directly in navigation mode.
                }
            }
        });
    }

    // toastyPopUp(): Creates and displays a Toast popup, informing the user that Google Maps needs
    // to be installed to continue.
    private void toastyPopUp() {

        // A Toast message appears, notifying the user that Google Maps is not installed.
        Toast.makeText(BHN_Main.this,
                "GOOGLE MAPS is not installed. Back Home Now requires GOOGLE MAPS.",+
                        Toast.LENGTH_SHORT).show();
    }
}
