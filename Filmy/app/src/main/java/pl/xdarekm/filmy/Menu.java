package pl.xdarekm.filmy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by uczen on 2017-10-21.
 */

public class Menu extends AppCompatActivity {
    private Button fromphonebtn;
    private EditText urlEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fromphonebtn = (Button) findViewById(R.id.from_url);
        urlEt = (EditText) findViewById(R.id.url_et);


        fromphonebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(),Videoplayer.class);
                intent.putExtra("video_to_play",urlEt.getText().toString());
                startActivity(intent);
            }
        });
    }
}
