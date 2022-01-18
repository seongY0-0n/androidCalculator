package com.cookandroid.hw2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {
    Button btnReturn;
    EditText edtResult;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edtResult = (EditText) findViewById(R.id.edtResult);
        btnReturn = (Button) findViewById(R.id.btnReturn);

        intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer rxNum1 = extras.getInt("Num1");
        Integer rxNum2 = extras.getInt("Num2");
        final int result = rxNum1 - rxNum2;

        edtResult.setText(rxNum1 + " - " + rxNum2 + " = " + result);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);
                outIntent.putExtra("SubResult",result);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}