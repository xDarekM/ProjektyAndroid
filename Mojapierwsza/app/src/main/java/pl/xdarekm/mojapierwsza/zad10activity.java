package pl.xdarekm.mojapierwsza;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by uczen on 2017-09-24.
 */

public class zad10activity extends AppCompatActivity {

    public Button przycisk1;
    public Button przycisk2;
    public Button przycisk3;
    public Button przycisk4;
    public Button przycisk5;
    public Button przycisk6;
    public Button przycisk7;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zadanie4);

        przycisk1 = (Button) findViewById(R.id.button1);
        przycisk2 = (Button) findViewById(R.id.button2);
        przycisk3 = (Button) findViewById(R.id.button3);
        przycisk4 = (Button) findViewById(R.id.button4);
        przycisk5 = (Button) findViewById(R.id.button5);
        przycisk6 = (Button) findViewById(R.id.button6);
        przycisk7 = (Button) findViewById(R.id.button7);

        przycisk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),przycisk1.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        przycisk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),przycisk2.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        przycisk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),przycisk3.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        przycisk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),przycisk4.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        przycisk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),przycisk5.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        przycisk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),przycisk6.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        przycisk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),przycisk7.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}