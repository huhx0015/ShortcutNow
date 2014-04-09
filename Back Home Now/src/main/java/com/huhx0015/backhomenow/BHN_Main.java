package com.huhx0015.backhomenow;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/** -----------------------------------------------------------------------------------------------
 *  [BHN_Main] CLASS
 *  PROGRAMMER: Michael Yoon Huh (HUHX0015)
 *  DESCRIPTION: MainActivity class is responsible for handling the first activity in the app and sets
 *  up the references and the click actions for the color buttons.
 *  -----------------------------------------------------------------------------------------------
 */

public class BHN_Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bhn_main); // Assigns the layout for the activity.
        setUpButtons(); // Sets up the button listeners for the activity.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bhn__main, menu);
        return true;
    }

    // Handles the settings button.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Adds the shortcut for MainActivity on Home screen
    private void setShortcut(int mode) {

        // Sets the reference to the address input.
        EditText address_1 = (EditText) findViewById (R.id.address_input_1);

        // Retrieves the address in the input string.
        String location = address_1.getText().toString();
        location = location.replace(" ", "+");

        // Sets the intent for the shortcut.
        // Launches Google Map in navigation mode and begins navigation immediately.
        Intent shortcutIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + location));
        shortcutIntent.setAction(Intent.ACTION_VIEW);

        // Creates the shortcut for the intent.
        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, this.getResources().getString(R.string.app_name));

        int iconResource = R.drawable.home_icon; // Used for determining the shortcut icon resource.

        // Sets the icon based on the selected mode.
        switch (mode) {

            case 0:
                iconResource = R.drawable.home_icon;
                break;

            case 1:
                iconResource = R.drawable.work_icon;
                break;

            case 2:
                iconResource = R.drawable.place_icon;
                break;
        }

        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                iconResource)); // Sets the icon resource for the shortcut.

        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT"); // Installs the shortcut on the homescreen.
        getApplicationContext().sendBroadcast(addIntent);
    }

    // setUpButtons(): Sets up the button listeners for the activity.
    private void setUpButtons() {

        // Assigns references to the ImageButton objects.
        ImageButton home_button = (ImageButton) findViewById(R.id.home_button);
        ImageButton work_button = (ImageButton) findViewById(R.id.work_button);
        ImageButton place_button = (ImageButton) findViewById(R.id.place_button);
        Button google_button = (Button) findViewById(R.id.google_button);

        // HOME
        home_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //launchIntent(0); // Launches the Google Maps intent with the "HOME" setting.
                setShortcut(0); // Sets the shortcut on the homescreen.
            }
        });

        // WORK
        work_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //launchIntent(1); // Launches the Google Maps intent with the "WORK" setting.
                setShortcut(1); // Sets the shortcut on the homescreen.
            }
        });

        // PLACE
        place_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //launchIntent(2); // Launches the Google Maps intent with the "PLACE" setting.
                setShortcut(2); // Sets the shortcut on the homescreen.
            }
        });

        // GOOGLE
        google_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                launchIntent(); // Launches the Google Maps intent with the "PLACE" setting.
            }
        });

    }

    // Launches Google Maps with immediate start of navigation.
    private void launchIntent() {

        // INSERT IMAGEVIEW INIT HERE
        EditText address_1 = (EditText)findViewById(R.id.address_input_1);

        // Retrieves the address in the input string.
        String location = address_1.getText().toString();
        location = location.replace(" ", "+");

        // Launches the intent.
        Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + location));
        i.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(i);
    }
}
