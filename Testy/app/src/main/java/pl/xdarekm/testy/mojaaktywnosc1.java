package pl.xdarekm.testy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by uczen on 2017-09-30.
 */

public class mojaaktywnosc1 extends AppCompatActivity {
     private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nowa_aktywnosc);
        btn = (Button) findViewById(R.id.guzik4);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),
                        "ZAAkceptowano",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
