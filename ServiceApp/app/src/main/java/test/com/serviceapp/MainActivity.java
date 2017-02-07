package test.com.serviceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText  pdf1;
    private EditText pdf2;
    private EditText pdf3;
    private EditText pdf4;
    private EditText pdf5;
    private Button startBttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdf1 = (EditText) findViewById(R.id.loc1);
        pdf2 = (EditText) findViewById(R.id.loc2);
        pdf3 = (EditText) findViewById(R.id.loc3);
        pdf4 = (EditText) findViewById(R.id.loc4);
        pdf5 = (EditText) findViewById(R.id.loc5);
        startBttn = (Button) findViewById(R.id.downloadBttn);

        startBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pathPdf1 = pdf1.getText().toString();
                String pathpdf2 = pdf2.getText().toString();
                String pathpdf3 = pdf3.getText().toString();
                String pathpdf4 = pdf4.getText().toString();
                String pathpdf5 = pdf5.getText().toString();
                String[] url = new String[]{pathPdf1,pathpdf2,pathpdf3,pathpdf4,pathpdf5};

                Intent intent = new Intent(getApplicationContext(), DownloadService.class);
                intent.putExtra("urls",url);
                startService(intent);
            }
        });
    }
}
