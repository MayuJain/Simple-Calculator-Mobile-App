package com.example.inclass04starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatingActivity extends AppCompatActivity {

    TextView activity;
    EditText number1;
    EditText number2;
    Button calculateButton;
    Double result = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculating);

        activity = findViewById(R.id.tv_activity);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        calculateButton = findViewById(R.id.bt_calculate);

        final String activityData = getIntent().getStringExtra(MainActivity.DATA_KEY);
        Log.d("demo", activityData);
        activity.setText(activityData);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double number1Value = Double.valueOf(number1.getText().toString());
                Double number2Value = Double.valueOf(number2.getText().toString());

                if(activityData.equals("Adding")){
                    result = number1Value + number2Value;
                }else{
                    result = number1Value - number2Value;
                }

                Intent intent = new Intent();
                Log.d("demo", result+"");
                intent.putExtra("Result",result);
                setResult(RESULT_OK,intent);
                finish();

            }
        });


    }
}
