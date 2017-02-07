package test.com.temphumidity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Ashutosh on 9/22/2016.
 */
public class TempBroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("custom.intent.temp_Request")) {
            MainActivity.flag = true;
        }
    }
}