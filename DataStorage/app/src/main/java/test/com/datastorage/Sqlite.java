package test.com.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;

public class Sqlite extends AppCompatActivity {
    private EditText msg ;
    private Button sqlBttn;
    private Button sqlCancel;
    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        msg= (EditText) findViewById(R.id.sqlMessage);
        sqlBttn = (Button) findViewById(R.id.saveSqlBttn);
        sqlCancel = (Button) findViewById(R.id.cancelMsgBttn);
        sqlCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Sqlite.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        databaseHandler = new DatabaseHandler(this);
        sqlBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String message= msg.getText().toString();
                String currentDate = DateFormat.getDateTimeInstance().format(new Date());
                System.out.println("Date"+currentDate);
                databaseHandler.insertMessage(message);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
