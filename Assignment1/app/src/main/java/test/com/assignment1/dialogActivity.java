package test.com.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class dialogActivity extends AppCompatActivity {
    private Button closeBttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
        closeBttn = (Button) findViewById(R.id.dialogCBttn);
        closeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishDialog(v);
            }
        });
    }


    public void finishDialog(View v) {
        dialogActivity.this.finish();
    }
}
