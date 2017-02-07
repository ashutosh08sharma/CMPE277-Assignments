package test.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static boolean flag = false;
    public static int temp_text;
    public static boolean fanFlag = false;
    public static boolean sprinklerFlag = false;
    public static int humid_text;
    public static String sprinklerMode;
    public static String fanMode;
    private Button tempHumidityBttn;
    private TextView tempVal;
    private TextView hVal;
    private TextView msg;
    private Button fanOn;
    private Button sprinklerOn;
    private static final String TAG = "MyActivity";
    private TextView fanStatus;
    private TextView sprinklerStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBttnClicked(View view) {
        tempHumidityBttn = (Button) findViewById(R.id.thBttn);
        tempHumidityBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("test.com.temphumidity");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        hVal = (TextView) findViewById(R.id.humidityVal);
        tempVal = (TextView) findViewById(R.id.TempValue);
        fanStatus = (TextView) findViewById(R.id.fanStatus);
        sprinklerStatus = (TextView) findViewById(R.id.sprinklerStatus);
        hVal.setVisibility(View.VISIBLE);
        tempVal.setVisibility(View.VISIBLE);

        Log.e("MyActivity", "" + +temp_text + flag);
        if (flag) {
            //String temp = String.valueOf(temp_text);
            tempVal.setText("" + temp_text);
            hVal.setText("" + humid_text);
            System.out.println("resumed" + humid_text);
        }

        if (fanFlag) {
            fanStatus.setText("" + fanMode);
            // sprinklerStatus.setText("" + sprinklerMode);
        }

        if (sprinklerFlag) {
            fanStatus.setText("" + fanMode);
            sprinklerStatus.setText("" + sprinklerMode);
        }
    }

    public void onClickFanOn(View view) {
        fanOn = (Button) findViewById(R.id.fanBttn);
        fanOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("test.com.farmmaintenance");
                startActivity(intent);
                System.out.println("requested");
            }
        });
    }

    public void onClickSprinkler(View view) {
        sprinklerOn = (Button) findViewById(R.id.fanSprinklerBttn);
        sprinklerOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("test.com.farmmaintenance");
                startActivity(intent);
                System.out.println("requested");
            }
        });
    }

}


