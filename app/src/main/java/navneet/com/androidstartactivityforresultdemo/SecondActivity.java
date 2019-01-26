package navneet.com.androidstartactivityforresultdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private static final int GET_REQUEST_CODE = 2;
    private Button send_message;
    private EditText txt_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        send_message=(Button)findViewById(R.id.send_message);
        txt_message=(EditText)findViewById(R.id.txt_message);

        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(txt_message.getText())) {
                    Intent intent=new Intent();
                    intent.putExtra("message",txt_message.getText().toString());
                    setResult(GET_REQUEST_CODE,intent);
                    finish();
                } else {
                    txt_message.setError("Field can't be empty!");
                }
            }
        });

    }
}
