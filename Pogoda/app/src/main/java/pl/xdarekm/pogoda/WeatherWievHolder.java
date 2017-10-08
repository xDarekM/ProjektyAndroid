package pl.xdarekm.pogoda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by uczen on 2017-10-08.
 */

public class WeatherWievHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView city;
    private TextView temp;
    private TextView date;
    private TextView desc;
    private Context context;


    public WeatherWievHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        image = (ImageView) itemView.findViewById(R.id.logo);
        city = (TextView) itemView.findViewById(R.id.city_res);
        temp = (TextView) itemView.findViewById(R.id.temp_res);
        date = (TextView) itemView.findViewById(R.id.date_res);
        desc = (TextView) itemView.findViewById(R.id.group);
    }

    public void bindData(Forcast f) {

        city.setText(f.getCity());
        temp.setText(f.getTemp() + "");
        date.setText(f.getDate());
        desc.setText(f.getDesc());

        Glide.with(context)
                .load("http://openweathermap.org/img/w/"+f.getIcon()+".png")
                .into(image);
    }

}
