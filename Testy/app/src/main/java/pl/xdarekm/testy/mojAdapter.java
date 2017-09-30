package pl.xdarekm.testy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by uczen on 2017-09-30.
 */

public class mojAdapter extends RecyclerView.Adapter <mojviewHolder>{


    private Context kontekst;
    private List<album> albums;


    public mojAdapter (Context kontekst ,List albums){

        this.albums =albums;
        this.kontekst = kontekst;
    }




    @Override
    public mojviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(kontekst).inflate(R.layout.item_layout,parent,false);
        return new mojviewHolder(view,kontekst,this);
    }

    @Override
    public void onBindViewHolder(mojviewHolder holder, int position) {

        album album=albums.get(position);
        holder.przypisaniieWidoku(album);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
    public void removeAlbum(int pos){
        albums.remove(pos);
        notifyItemRemoved(pos);
    }
    public void addAlbum(album Album){
        albums.add(Album);
        notifyItemInserted(albums.size());

    }
}

