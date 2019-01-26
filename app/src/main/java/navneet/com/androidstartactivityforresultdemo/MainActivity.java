package navneet.com.androidstartactivityforresultdemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final int GET_REQUEST_CODE = 2;
    private Button result_fetch;
    private TextView result_box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result_fetch=(Button)findViewById(R.id.result_fetch);
        result_box=(TextView) findViewById(R.id.result_box);
        result_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent, GET_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode== GET_REQUEST_CODE) {
            result_box.setText(data.getStringExtra("message"));
        } else {
            Toast.makeText(this,"Failed!",Toast.LENGTH_SHORT).show();
        }

    }
}
