package test.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Ashutosh on 9/22/2016.
 */
public class TempBroadcastReciever extends BroadcastReceiver {
    private static final String TAG = "MyActivity";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("custom.intent.temp_Response")) {
            MainActivity.flag = true;
            MainActivity.temp_text = (intent.getExtras().getInt("temperature"));
            MainActivity.humid_text = (intent.getExtras().getInt("humidity"));
            Log.d("MyActivity", "" + MainActivity.temp_text + MainActivity.humid_text);
        }
        if (intent.getAction().equals("custom.intent.Fan_Response")) {
            MainActivity.fanFlag = true;
            //System.out.println(intent.getExtras().getFloat("temperature"));
            MainActivity.fanMode = (intent.getExtras().getString("FANSTATUS"));
            Log.d("MyActivity", "" + MainActivity.fanMode + MainActivity.sprinklerMode);
        }
        if (intent.getAction().equals("custom.intent.Sprinkler_Response")) {
            MainActivity.sprinklerFlag = true;
            //System.out.println(intent.getExtras().getFloat("temperature"));
            MainActivity.fanMode = (intent.getExtras().getString("FANSTATUS"));
            MainActivity.sprinklerMode = (intent.getExtras().getString("Sprinkler"));
            Log.d("MyActivity", "" + MainActivity.fanMode + MainActivity.sprinklerMode);
        }
    }
}
