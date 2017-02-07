package test.com.assignment1;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mainActivity extends AppCompatActivity {
    private static final String CountKey = "CountKey";
    private static final String CountThread="CountThread";

    private Button actA;
    private Button dialog;
    private  Button closeBttn;
    TextView count;
    TextView countonDes;
    TextView threadCounter;
    int counts = 0;
    int countValue=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actA = (Button) findViewById(R.id.actBttn);
        dialog = (Button) findViewById(R.id.dialogBttn);
        countonDes = (TextView) findViewById(R.id.count);
        threadCounter= (TextView) findViewById(R.id.threadCount);
        count = (TextView) findViewById(R.id.countValue);
        closeBttn = (Button) findViewById(R.id.closebutton);
        actA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity.this,activityB.class);
                startActivity(intent);
            }
        });
        if (savedInstanceState !=null) {

            // TODO:
            // Restore value of counters from saved state

            counts = savedInstanceState.getInt(CountKey);
            countValue=savedInstanceState.getInt(CountThread);
        }

         count.setText(String.valueOf(counts));
        countonDes.setText(String.valueOf(countValue));
        counts++;
        closeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivityA();
            }
        });

        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        // custom dialog
                        Intent dialogIntent = new Intent(mainActivity.this,dialogActivity.class);
                        startActivity(dialogIntent);
                    }
                });
            }

    private void finishActivityA() {
        mainActivity.this.finish();
    }


    private void display() {
        count.setText(String.valueOf(counts));
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();;
        display();
    }

    @Override
    protected void onPause() {
        super.onPause();
        counts++;
    }

    @Override
    protected void onStop() {
        super.onStop();
        threadCounter.setVisibility(View.VISIBLE);
        countonDes.setVisibility(View.VISIBLE);
        countValue++;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //TODO:
        savedInstanceState.putInt(CountKey, counts);
        savedInstanceState.putInt(CountThread, countValue);

    }
}
