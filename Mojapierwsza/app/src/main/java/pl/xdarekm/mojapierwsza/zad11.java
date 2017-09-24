package pl.xdarekm.mojapierwsza;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by uczen on 2017-09-24.
 */

public class zad11 extends AppCompatActivity {
    EditText edit;
    Button btn;
    EditText edit2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zad6);
        edit = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        btn = (Button) findViewById(R.id.button8);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean czyMogeLogowac = true;
                if (edit.getText().toString().isEmpty()) {
                    edit.setError("Login nie może być pusty");
                    czyMogeLogowac = false;
                } else {
                    edit.setError(null);
                }
                if (edit2.getText().toString().isEmpty()) {
                    edit2.setError("Hasło nie może być puste");
                    czyMogeLogowac = false;
                } else {
                    edit.setError(null);
                }

                if (czyMogeLogowac) {
                    if (edit.getText().toString().equals("user") &&
                            edit2.getText().toString().equals("123")) {
                        Toast.makeText(getApplicationContext(), "Zalogowano", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Nie zalogowano", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}



