package test.com.temphumidity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button setTemp;
    private EditText tempValue;
    private EditText humidityValue;
    public static boolean flag = false;
    public static int temp, humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempValue = (EditText) findViewById(R.id.temp);
        humidityValue = (EditText) findViewById(R.id.humid);
        tempValue = (EditText) findViewById(R.id.temp);
        humidityValue = (EditText) findViewById(R.id.humid);
        setTemp = (Button) findViewById(R.id.setBttn);
        setTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = Integer.valueOf(tempValue.getText().toString());
                System.out.println(temp);
                humidity = Integer.valueOf(humidityValue.getText().toString());
                Intent intent = new Intent("custom.intent.temp_Response");
                intent.setAction("custom.intent.temp_Response");
                intent.putExtra("temperature", temp);
                intent.putExtra("humidity", humidity);
                sendBroadcast(intent);
                System.out.println("out" + temp);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
