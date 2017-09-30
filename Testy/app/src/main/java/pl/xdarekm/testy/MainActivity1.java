package pl.xdarekm.testy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-09-30.
 */

public class MainActivity1 extends AppCompatActivity {
    private RecyclerView recycler;
    private FloatingActionButton aktywny;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        recycler = (RecyclerView) findViewById(R.id.tekst);
        aktywny = (FloatingActionButton) findViewById(R.id.latajacy);

        List<album> albums = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            albums.add(new album("egzotyka", "2017", "Quebonofide", R.drawable.egzotyka));
            albums.add(new album("Dla fanów elektryki", "2017", "Quebonofide", R.drawable.dlafanowelektryki));
            albums.add(new album("Dla fanek euforii", "2017", "Quebonofide", R.drawable.dlafanekeuforii));
            albums.add(new album("Hip Hop", "2015", "Quebonofide", R.drawable.hiphop));
        }
        final mojAdapter adapter = new mojAdapter(this, albums);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        aktywny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                album album1= new album("Hip Hop", "2015", "Quebonofide", R.drawable.hiphop);
                adapter.addAlbum(album1);
                recycler.scrollToPosition(adapter.getItemCount()-1);

            }
        });
    }

}