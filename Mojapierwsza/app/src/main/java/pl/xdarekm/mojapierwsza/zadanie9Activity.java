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

public class zadanie9Activity extends AppCompatActivity {

   private  EditText editText;
   private Button przycisk;
   private TextView wyswietlacz;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zadnie9);
        editText = (EditText) findViewById(R.id.text);
        przycisk = (Button)  findViewById(R.id.guzik);
        wyswietlacz = (TextView) findViewById(R.id.wyswietlacz);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String s =  editText.getText().toString();
             wyswietlacz.setText(s);
            }

        });

    }
}