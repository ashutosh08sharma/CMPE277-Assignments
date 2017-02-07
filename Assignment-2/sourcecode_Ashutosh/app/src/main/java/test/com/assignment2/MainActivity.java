package test.com.assignment2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText urlText;
    private EditText numberText;
    private Button launch, ring, closeApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlText = (EditText) findViewById(R.id.url);
        numberText = (EditText) findViewById(R.id.phoneNo);
        launch = (Button) findViewById(R.id.launchBttn);
        closeApp = (Button) findViewById(R.id.closeBttn);
        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String webPage = urlText.getText().toString();
                System.out.println(webPage);
                Uri webpage = Uri.parse("http://"+webPage);
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(webpage);
                startActivity(webIntent);
            }
        });

        ring = (Button) findViewById(R.id.ringBttn);
        ring.setOnClickListener(new View.OnClickListener() {
            String phNumber = numberText.getText().toString();
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ phNumber));
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities =
                        packageManager.queryIntentActivities(callIntent, 0);
                boolean isIntentSafe = activities.size() > 0;
                startActivity(callIntent);
            }
        });
        closeApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

    }

}



