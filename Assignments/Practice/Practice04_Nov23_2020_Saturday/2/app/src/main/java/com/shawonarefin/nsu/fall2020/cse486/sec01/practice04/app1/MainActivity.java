package com.shawonarefin.nsu.fall2020.cse486.sec01.practice04.app1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sendButton;
    TextView phoneNumberEditText;
    TextView smsEditText;

    public static final int DEFAULT_SMS_APP = 1;
    public static final int GOOGLE_HANGOUT_APP = 2;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = (Button) findViewById(R.id.sendButton);
        phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        smsEditText = (EditText) findViewById(R.id.smsEditText);

        Context context  = getApplicationContext();
        Log.d("onCreate", "Calling onCreate Method");
        Toast toast = Toast.makeText(context, "Calling onCreate Method", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
        toast.show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null)
            counter = Integer.valueOf(savedInstanceState.getString("count","0"));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Context context  = getApplicationContext();
        Log.d("OnStart", "Calling onStart Method");
        Toast toast = Toast.makeText(context, "Calling onStart Method", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.LEFT,10,15);
        toast.show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Context context  = getApplicationContext();
        Log.d("onStop", "Calling onStop Method");
        Toast toast = Toast.makeText(context, "Calling onStop Method", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.LEFT,10,15);
        toast.show();
    }


    @Override
    protected void onRestart() {
        super.onRestart();

        Context context  = getApplicationContext();
        Log.d("onRestart", "Calling onRestart Method");
        Toast toast = Toast.makeText(context, "Calling onRestart Method", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.LEFT,10,25);
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Context context  = getApplicationContext();
        Log.d("onResume", "Calling onResume Method");
        Toast toast = Toast.makeText(context, ("Counter :" + counter), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.LEFT,0,0);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Context context  = getApplicationContext();
        Log.d("onPause", "Calling onPause Method");
        Toast toast = Toast.makeText(context, "Calling onPause Method", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Context context  = getBaseContext();
        Log.d("onDestroy", "Calling onDestroy Method");
        Toast toast = Toast.makeText(context, "Calling onDestroy Method", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
        toast.show();
    }

    public void sendAction(View view) {
        /*
        Context context  = getApplicationContext();
        Toast toast = Toast.makeText(context
                , (phoneNumberEditText.getText()+ " , "+smsEditText.getText())
                , Toast.LENGTH_SHORT);
        toast.show();

         */
        counter++;
        Uri uri = Uri.parse("sms:8005551234");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body",smsEditText.getText().toString());
        startActivityForResult(it, DEFAULT_SMS_APP);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Add information for saving HelloToast counter
        // to the to the outState bundle
        outState.putString("count", String.valueOf(counter));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case DEFAULT_SMS_APP:
                if(resultCode == Activity.RESULT_OK){
                    Toast toast = Toast.makeText(this, "Result OK", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(resultCode == Activity.RESULT_CANCELED){
                    Toast toast = Toast.makeText(this, "Result was cancelled", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;

            default:
                break;
        }

    }
}