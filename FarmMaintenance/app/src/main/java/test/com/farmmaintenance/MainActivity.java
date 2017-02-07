package test.com.farmmaintenance;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button sprinkleBttn;
    private Button fanBttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fanBttn = (Button) findViewById(R.id.fanButton);
        sprinkleBttn = (Button) findViewById(R.id.spBttn);
    }


    @Override
    protected void onResume(){
        super.onResume();
       {
            fanBttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent intent = new Intent("custom.intent.Fan_Response");
                        intent.putExtra("FANSTATUS", "ON");
                       // intent.putExtra("Sprinker", "ON");
                        sendBroadcast(intent);
                        System.out.println("response back");
                    }
            });

           sprinkleBttn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent("custom.intent.Sprinkler_Response");
                   intent.putExtra("FANSTATUS","ON");
                   intent.putExtra("Sprinkler", "ON");
                   sendBroadcast(intent);

               }
           });

        }

    }
}
