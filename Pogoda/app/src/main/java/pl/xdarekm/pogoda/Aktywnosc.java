package pl.xdarekm.pogoda;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by uczen on 2017-10-08.
 */

public class Aktywnosc extends AppCompatActivity {
    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private Button btn;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private EditText editText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pogodalayout);

        textView = (TextView) findViewById(R.id.deg);
        textView1 = (TextView) findViewById(R.id.city);
        editText = (EditText) findViewById(R.id.city_et);
        btn = (Button) findViewById(R.id.cel);
        btn1 = (Button) findViewById(R.id.far);
        btn2 = (Button) findViewById(R.id.kal);
        btn3 = (Button) findViewById(R.id.change);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences stopnie = getSharedPreferences("pogoda",Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = stopnie.edit();
                editor.putString("stopnie", "C");
                editor.commit();
                textView.setText("C");
                Toast.makeText(getApplicationContext(), "Wybrano pomyślnie Celsius", Toast.LENGTH_SHORT).show();
            }

        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences stopnie = getSharedPreferences("pogoda",Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = stopnie.edit();
                editor.putString("stopnie", "F");
                editor.commit();
                textView.setText("F");
                Toast.makeText(getApplicationContext(), "Wybrano pomyślnie Farenheit", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences stopnie = getSharedPreferences("pogoda",Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = stopnie.edit();
                editor.putString("stopnie", "K");
                editor.commit();
                textView.setText("K");
                Toast.makeText(getApplicationContext(), "Wybrano pomyślnie Kelviny", Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpref = getSharedPreferences("pogoda",Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpref.edit();
                editor.putString("city",editText.getText().toString());
                textView1.setText(editText.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(), "Zmieniono pomyślnie miasto", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpref = getSharedPreferences("pogoda",Activity.MODE_PRIVATE);
        String wartosc = sharedpref.getString("stopnie", "C");
        textView.setText(wartosc);

        String wartosc1 = sharedpref.getString("city", "Warszawa");
        textView1.setText(wartosc1);
    }

}

