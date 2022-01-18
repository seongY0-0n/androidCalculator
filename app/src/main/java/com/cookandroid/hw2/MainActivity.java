package com.cookandroid.hw2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2, edtResult;
    RadioGroup rdoGroup;
    RadioButton Add, Sub, Mul;
    Button btnCount;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        edtResult = (EditText) findViewById(R.id.edtResult);
        rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup);
        Add = (RadioButton) findViewById(R.id.Add);
        Sub = (RadioButton) findViewById(R.id.Sub);
        Mul = (RadioButton) findViewById(R.id.Mul);
        btnCount = (Button) findViewById(R.id.btnCount);
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(rdoGroup.getCheckedRadioButtonId()){
                    case R.id.Add:
                        intent = new Intent(getApplicationContext(),AddActivity.class);
                        intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                        intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                        startActivityForResult(intent, 1001);
                        break;
                    case R.id.Sub:
                        intent = new Intent(getApplicationContext(),SubActivity.class);
                        intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                        intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                        startActivityForResult(intent, 1002);
                        break;
                    case R.id.Mul:
                        intent = new Intent(getApplicationContext(),MulActivity.class);
                        intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                        intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                        startActivityForResult(intent, 1003);
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1001:
                if(resultCode==RESULT_OK){
                    int result = data.getExtras().getInt("AddResult");
                    edtResult.setText("계산 결과: " + result);
                }
                break;
            case 1002:
                if(resultCode==RESULT_OK){
                    int result = data.getExtras().getInt("SubResult");
                    edtResult.setText("계산 결과: " + result);
                }
                break;
            case 1003:
                if(resultCode==RESULT_OK){
                    int result = data.getExtras().getInt("MulResult");
                    edtResult.setText("계산 결과: " + result);
                }
                break;

        }
    }
}