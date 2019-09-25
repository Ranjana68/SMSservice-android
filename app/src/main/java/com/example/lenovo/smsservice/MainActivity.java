package com.example.lenovo.smsservice;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        btn=findViewById(R.id.button);

        //for run time permission
        //only "this" because we are inside on create not inside any anonymous class
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0);//req code to os as i identity from our app
            return;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number=e1.getText().toString();
                String message=e2.getText().toString();

                SmsManager sms=SmsManager.getDefault();//default reads the sms service of phone and stores in variable sms
                sms.sendTextMessage(number,null,message,null,null);

            }
        });

    }
}
