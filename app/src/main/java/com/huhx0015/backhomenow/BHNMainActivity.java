package com.huhx0015.backhomenow;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;



public class BHNMainActivity extends AppCompatActivity {

    /** ACTIVITY LIFECYCLE FUNCTIONALITY _______________________________________________________ **/

    // onCreate(): The initial function that is called when the activity is run. onCreate() only runs
    // when the activity is first started.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bhn_main); // Assigns the layout for the activity.
       // setUpButtons(); // Sets up the button listeners for the activity.
    }

    /** ADDITIONAL FUNCTIONALITY _______________________________________________________________ **/
//
//
//
//
//
//    // setUpButtons(): Sets up the button listeners for the activity.
//    private void setUpButtons() {
//
//        // Assigns references to the ImageButton objects.
//        ImageButton home_button = (ImageButton) findViewById(R.id.home_button);
//        ImageButton work_button = (ImageButton) findViewById(R.id.work_button);
//        ImageButton place_button = (ImageButton) findViewById(R.id.place_button);
//        Button google_button = (Button) findViewById(R.id.google_button);
//
//        // HOME Button:
//        home_button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                // Checks to see if Google Maps is installed first.
//                if ( !(checkForAppInstalled("com.google.android.apps.maps")) ) {
//
//                    // Displays a Toast popup.
//                    toastyPopUp("GOOGLE MAPS is not installed. Back Home Now requires GOOGLE MAPS.");
//                }
//
//                // Otherwise, the shortcut is created.
//                else {
//                    setShortcut(0); // Sets the "HOME" shortcut on the homescreen.
//                }
//            }
//        });
//
//        // WORK Button:
//        work_button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // Checks to see if Google Maps is installed first.
//                if ( !(checkForAppInstalled("com.google.android.apps.maps")) ) {
//
//                    // Displays a Toast popup.
//                    toastyPopUp("GOOGLE MAPS is not installed. Back Home Now requires GOOGLE MAPS.");
//                }
//
//                // Otherwise, the shortcut is created.
//                else {
//                    setShortcut(1); // Sets the "WORK" shortcut on the homescreen.
//                }
//            }
//        });
//
//        // PLACE Button:
//        place_button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                // Checks to see if Google Maps is installed first.
//                if ( !(checkForAppInstalled("com.google.android.apps.maps")) ) {
//
//                    // Displays a Toast popup.
//                    toastyPopUp("GOOGLE MAPS is not installed. Back Home Now requires GOOGLE MAPS.");
//                }
//
//                // Otherwise, the shortcut is created.
//                else {
//                    setShortcut(2); // Sets the "PLACE" shortcut on the homescreen.
//                }
//            }
//        });
//
//        // GOOGLE MAPS Button:
//        google_button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                // Checks to see if Google Maps is installed first.
//                if ( !(checkForAppInstalled("com.google.android.apps.maps")) ) {
//
//                    // Displays a Toast popup.
//                    toastyPopUp("GOOGLE MAPS is not installed. Back Home Now requires GOOGLE MAPS.");
//                }
//
//                // Otherwise, the shortcut is created.
//                else {
//                    launchIntent(); // Launches the Google Maps intent directly in navigation mode.
//                }
//            }
//        });
//    }


}