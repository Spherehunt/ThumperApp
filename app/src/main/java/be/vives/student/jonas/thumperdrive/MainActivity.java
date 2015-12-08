package be.vives.student.jonas.thumperdrive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "Selected settings", Toast.LENGTH_SHORT).show();
                Intent SettingsActivity = new Intent(this, SettingsActivity.class);
                startActivity(SettingsActivity);
                return true;
            case R.id.action_about:
                Toast.makeText(this, "Selected about", Toast.LENGTH_SHORT).show();
                Intent about = new Intent(this, AboutActivity.class);
                startActivity(about);
                return true;
            case R.id.action_neopixel:
                Toast.makeText(this, "Selected neopixel", Toast.LENGTH_SHORT).show();
                Intent NeoPixel = new Intent(this, NeoPixelActivity.class);
                startActivity(NeoPixel);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onAutomaticDriveClick(View view){
        Intent AutoDrive = new Intent(this, AutomaticDriveActivity.class);
        startActivity(AutoDrive);
    }
    public void onManualDriveClick(View view){
        Intent ManualDrive = new Intent(this, ManualDriveActivity.class);
        startActivity(ManualDrive);
    }

}

