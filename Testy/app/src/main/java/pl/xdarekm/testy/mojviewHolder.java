package pl.xdarekm.testy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by uczen on 2017-09-30.
 */

public class mojviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {


    private TextView autor;
    private TextView rok;
    private TextView tytuł;
    private ImageView okladka;
    private Context contekst;
    private mojAdapter adapter;


    public mojviewHolder(View itemView,Context contekst,mojAdapter adapter) {
        super(itemView);
        this.contekst=contekst;
        this.adapter=adapter;
        autor= (TextView) itemView.findViewById(R.id.text1);
        rok = (TextView) itemView.findViewById(R.id.text3);
        tytuł=(TextView) itemView.findViewById(R.id.text2);
        okladka=(ImageView) itemView.findViewById(R.id.wyswietlacz);
       itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }
    public void przypisaniieWidoku(album plyta){

        autor.setText(plyta.getAutor());
        rok.setText(plyta.getData_wydania());
        tytuł.setText(plyta.getTytuł());
        okladka.setImageDrawable(contekst.getResources().getDrawable(plyta.getId_okladki()));
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(contekst, tytuł.getText(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onLongClick(View v) {

        adapter.removeAlbum(getAdapterPosition());
        return false;
    }
}
