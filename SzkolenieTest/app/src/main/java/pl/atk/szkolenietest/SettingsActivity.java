package pl.atk.szkolenietest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Tomasz on 04.11.2017.
 */

public class SettingsActivity extends AppCompatActivity {

    private TextView prefLang;
    private Button changeBtn;
    //todo 15: dodaj edit text w kodzie

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        prefLang = (TextView) findViewById(R.id.prefs_lang_tv);
        changeBtn = (Button) findViewById(R.id.change_btn);

        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 16: zapisz dane do shared preferences
                //todo 17: zmien text w textview
                //todo 18: wyświetl toast który poinformuje użytkownaika że zmiany zostały zapisane
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        //todo 19: pobierz aktualnie zapisany język i wyświetl go w textview
    }
}
