package test.com.datastorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button openSql;
    private Button openSharedPref;
    private Button closeApp;
     private TextView sharedView;
    private TextView sqlView;
    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedView = (TextView) findViewById(R.id.sharedPref);
        openSql = (Button) findViewById(R.id.sqlBttn);
        openSharedPref = (Button) findViewById(R.id.preBttn);
        closeApp = (Button) findViewById(R.id.closeApp);
        sqlView = (TextView) findViewById(R.id.sqlView);
        databaseHandler = new DatabaseHandler(this);
        openSql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sqlIntent = new Intent(getApplicationContext(),Sqlite.class);
                startActivity(sqlIntent);
            }
        });
        openSharedPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharedIntent = new Intent(getApplicationContext(),SharedPreference.class);
                startActivity(sharedIntent);
            }
        });
        closeApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        sharedView.setVisibility(View.VISIBLE);
        sqlView.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        String  msgSharedPref = intent.getStringExtra("Data");
        sharedView.setText("Shared Preference : " +msgSharedPref);
        String Sql = databaseHandler.getAllMessage();
        System.out.println("Result"+Sql);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        sqlView.setText("SQLite :"+Sql+" "+currentDateTimeString);
    }
    @Override
    public void onPause(){
        super.onPause();
        Intent intent = getIntent();
        String  msgSharedPref = intent.getStringExtra("Data");
        sharedView.setText("Shared Preference : " +msgSharedPref);

    }

}
