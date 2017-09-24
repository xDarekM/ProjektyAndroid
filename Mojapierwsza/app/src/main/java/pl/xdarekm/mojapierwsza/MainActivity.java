package pl.xdarekm.mojapierwsza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private TextView wyswietlacz;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wyswietlacz);
        wyswietlacz = (TextView) findViewById(R.id.wyswietlacz);

        Film film = new Film("Pulp Fiction",154);
        Film film1 = new Film("Wladcy moch", 160);
        Film film2 = new Film ("Kocham Cie Polsko",200);
        Film film3 = new Film ("jaka to melodia",299);
        Film film4 = new Film ("tak to lecialo",166);

        LinkedList<Film> lista1= new LinkedList<>();

        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);
        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);
        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);
        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);
        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);
        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);
        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);
        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);
        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);
        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);
        lista1.add(film);
        lista1.add(film1);
        lista1.add(film2);
        lista1.add(film3);
        lista1.add(film4);



        for(int i=0;i<lista1.size();i++ ){
            wyswietlacz.append(lista1.get(i).getTitle() + " "+ lista1.get(i).getLength() + "\n");

        }

    }



}



