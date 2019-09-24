package vn.edu.bai2lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.edtName);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
              String name=intent.getStringExtra("name");
                Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
            }
        };
        IntentFilter intentFilter=new IntentFilter("abc");
        registerReceiver(broadcastReceiver,intentFilter);
    }

    public void Send(View view) {
        Intent intent=new Intent("abc");
        intent.putExtra("name",edtName.getText().toString().trim());
        sendBroadcast(intent);
    }
}
