package pl.xdarekm.testy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button btn1;
    private Button btn2;
    private TextView tekst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.guzik1);
        btn1 = (Button) findViewById(R.id.guzik2);
        btn2 = (Button) findViewById(R.id.guzik3);
        tekst = (TextView) findViewById(R.id.text1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekst.setTextColor(getResources().getColor(R.color.czerwony));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekst.setTextColor(getResources().getColor(R.color.niebieski));
            }


        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekst.setTextColor(getResources().getColor(R.color.zielony));
            }


        });

    }
}
