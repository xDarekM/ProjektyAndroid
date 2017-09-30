package pl.xdarekm.testy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by uczen on 2017-09-30.
 */

public class mojviewHolder extends RecyclerView.ViewHolder {

    private TextView autor;
    private TextView rok;
    private TextView tytuł;
    private ImageView okladka;
    private Context contekst;



    public mojviewHolder(View itemView,Context contekst) {
        super(itemView);
        this.contekst=contekst;
        autor= (TextView) itemView.findViewById(R.id.text1);
        rok = (TextView) itemView.findViewById(R.id.text3);
        tytuł=(TextView) itemView.findViewById(R.id.text2);
        okladka=(ImageView) itemView.findViewById(R.id.wyswietlacz);

    }
    public void przypisaniieWidoku(album plyta){

        autor.setText(plyta.getAutor());
        rok.setText(plyta.getData_wydania());
        tytuł.setText(plyta.getTytuł());
        okladka.setImageDrawable(contekst.getResources().getDrawable(plyta.getId_okladki()));
    }

}
