package test.com.datastorage;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DateFormat;
import java.util.Date;

public class SharedPreference extends AppCompatActivity {
    private EditText bookName;
    private Button saveBtn;
    private Button cancelBtn;
    private EditText authorName;
    private EditText description;
    private String message;
    private String authName;
    private String descriptn;
    private static final String TAG = "SharedPreference";
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String SharedMessage = "Message";
    SharedPreferences sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        bookName = (EditText) findViewById(R.id.sharedMsg);
        saveBtn = (Button) findViewById(R.id.ssBttn);
        authorName = (EditText) findViewById(R.id.bookAuthor);
        description = (EditText) findViewById(R.id.descView);
        cancelBtn = (Button) findViewById(R.id.cancelBttn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SharedPreference.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        sharedPreference = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = bookName.getText().toString();
                descriptn = description.getText().toString();
                authName = authorName.getText().toString();
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString(SharedMessage, message+descriptn+authName);
                editor.commit();
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                Intent intent = new Intent(SharedPreference.this, MainActivity.class);
                System.out.println("shared" + message + " " + currentDateTimeString);
                intent.putExtra("Data", message + " " + currentDateTimeString);
                startActivity(intent);
            }
        });
    }
}
