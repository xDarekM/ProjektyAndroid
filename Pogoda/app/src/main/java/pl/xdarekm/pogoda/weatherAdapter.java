package pl.xdarekm.pogoda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by uczen on 2017-10-08.
 */

public class weatherAdapter extends RecyclerView.Adapter<WeatherWievHolder> {

    private Context context;
    private List<Forcast> forcasts;

    public weatherAdapter(Context context, List forcasts) {
        this.context = context;
        this.forcasts = forcasts;


    }

    @Override
    public WeatherWievHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_weather, parent, false);
        return new WeatherWievHolder(view, context);
    }


    @Override
    public void onBindViewHolder(WeatherWievHolder holder, int position) {
        holder.bindData(forcasts.get(position));
    }

    @Override
    public int getItemCount() {
        return forcasts.size();
    }
    public void podmienListe(List<Forcast>list){
        list.clear();
        for (int i = 0; i <list.size();i++){
            forcasts.add(list.get(i));
            notifyItemInserted(forcasts.size() -1);
        }
    }
}
