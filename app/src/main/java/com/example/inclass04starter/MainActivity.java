package com.example.inclass04starter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String DATA_KEY = "DATA";
    final static int REQ_CODE_ADD = 100;
    final static int REQ_CODE_SUBSTRACT = 101;

    Button addBt;
    Button subBt;
    TextView calCulate;
    String flag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBt = findViewById(R.id.bt_add);
        subBt = findViewById(R.id.bt_subtract);
        calCulate = findViewById(R.id.tv_res);

        addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = "Adding";
                Intent intent = new Intent(MainActivity.this, CalculatingActivity.class);
                intent.putExtra(DATA_KEY, flag);
                startActivityForResult(intent, REQ_CODE_ADD);
                // finish();
            }
        });

        subBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = "Substracting";
                Intent intent = new Intent(MainActivity.this, CalculatingActivity.class);
                intent.putExtra(DATA_KEY, flag);
                startActivityForResult(intent, REQ_CODE_ADD);
            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == REQ_CODE_ADD){
            if(resultCode == RESULT_OK){
                String result = data.getExtras().get("Result").toString();
                Log.d("demo1", result+"");
                calCulate.setText(result);
            }
        }
    }
}
