package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener {
    private EditText inputDecimal ;
    private EditText inputBinary ;
    private Button resetButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputDecimal = (EditText) findViewById(R.id.input_decimal);
        inputBinary = (EditText) findViewById(R.id.input_binary);
        resetButton = (Button) findViewById(R.id.reset_button);

        inputDecimal.setOnKeyListener(this);
        inputBinary.setOnKeyListener(this);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDecimal.setText("");
            inputBinary.setText("");
            }
        });

    }
    static int binaryToDecimal(String binary){
        int i = binary.length()-1;
        int decimal = 0;
        while( i > -1){
            if ('1' == binary.charAt((binary.length()-1) - i)) decimal += Math.pow(2,i);
            i--;
        }
        return decimal ;
    }
    static String decimalToBinary(double decimal){
        String binary = "";
        while (Math.floor(decimal) != 0.0){
            if(Math.floor(decimal) % 2 == 0.0){
                binary = "0" + binary;
            }else{
                binary = "1" + binary;
            }
            decimal = Math.floor(decimal) / 2;
        }
        return binary;
    }

    @Override
    public boolean onKey(View v, int i, KeyEvent keyEvent) {
        String decimal = inputDecimal.getText().toString();
        String binary = inputBinary.getText().toString();
        if(v.getId() ==R.id.input_decimal){
            if (decimal.length() > 0){
                inputBinary.setText(decimalToBinary(Double.parseDouble(decimal)));
            }else{
                inputDecimal.setText("");
                inputBinary.setText("");
            }
        }
        if(v.getId() ==R.id.input_binary){
            if (binary.length() > 0){
                inputDecimal.setText(binaryToDecimal(binary)+"");
            }else{
                inputDecimal.setText("");
                inputBinary.setText("");
            }
        }
        return false;
    }
}