package be.vives.student.jonas.thumperdrive;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class NeoPixelActivity extends Activity {

    private Retrofit retrofit;
    private NeoPixelService service;
    private String base_url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_neo_pixel);
    }



    public void onGetClick(View view){
        Toast.makeText(this, "Getting string info", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String id = sharedPref.getString(SettingsActivity.PREF_KEY_NEOPXLSTRINGID, "");
        Call<NeoPixelString> callStringInfo = service.getNeoPixelStringInfo(id);
        callStringInfo.enqueue(new Callback<NeoPixelString>() {
            @Override
            public void onResponse(Response<NeoPixelString> response, Retrofit retrofit) {
                if (response.body() != null) {
                    NeoPixelString str = response.body();
                    Log.i("REST", response.toString());
                    Log.i("REST", "ID =" + str.getStringId() + "COUNT = " + str.getNumberOfPixels());
                    ((EditText) findViewById(R.id.NumberofPixelsinput)).setText(str.getNumberOfPixels());
                } else {
                    Log.e("REST", "Request returned no data");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("REST", t.toString());
                Toast.makeText(getApplicationContext(), "Request failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void initRetrofit(){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String serverip = sharedPref.getString(SettingsActivity.PREF_KEY_SERVERIP, "");
        String serverport = sharedPref.getString(SettingsActivity.PREF_KEY_SERVERPORT, "");

        base_url = "http://" + serverip + ":" + serverport + "/";

        retrofit= new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(NeoPixelService.class);
    }

    protected void onResume(){
        super.onResume();
        initRetrofit();
    }

    public void onSetNeoPixelColorClick(View v){
        Toast.makeText(this, "Setting color", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String id = sharedPref.getString(SettingsActivity.PREF_KEY_NEOPXLSTRINGID, "");
        int red = ((SeekBar) findViewById(R.id.RedSeekBar)).getProgress();

        int green = ((SeekBar) findViewById(R.id.GreenSeekBar)).getProgress();

        int blue = ((SeekBar) findViewById(R.id.BlueSeekBar)).getProgress();

        int delay = ((SeekBar) findViewById(R.id.DelaySeekBar)).getProgress();



        NeoPixelColorEffect color = new NeoPixelColorEffect(red,green,blue);

        Call<StatusReport> callSetNeoPixel;

        if(delay <10 || delay>255){
            NeoPixelColorEffect ColorEffect = new NeoPixelColorEffect(red,green,blue);
            callSetNeoPixel = service.setNeoPixelLedColor(id,ColorEffect);
        }

       else{
            NeoPixelStrobeEffect strobeEffect = new NeoPixelStrobeEffect(red,green,blue,delay);
            callSetNeoPixel = service.setNeoPixelStrobe(id, strobeEffect);
        }

        callSetNeoPixel.enqueue(new Callback<StatusReport>() {
            @Override
            public void onResponse(Response<StatusReport> response, Retrofit retrofit) {
                if(response.body()!=null){
                    StatusReport status = response.body();
                    Log.i("REST",response.toString());
                }
                else{
                    Log.e("REST","Request returned no data");
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.i("REST", t.toString());
                Toast.makeText(getApplicationContext(),"Request failed",Toast.LENGTH_SHORT).show();

            }
        });
    }

}
