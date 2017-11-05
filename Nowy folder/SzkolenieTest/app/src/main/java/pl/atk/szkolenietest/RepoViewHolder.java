package pl.atk.szkolenietest;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Tomasz on 04.11.2017.
 */

public class RepoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;
    private TextView name;
    private ImageView obr1;
    private TextView user;
    private Repo repo;

    public RepoViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        name = (TextView) itemView.findViewById(R.id.tex1);
        user = (TextView) itemView.findViewById(R.id.tex2);
        obr1 = (ImageView) itemView.findViewById(R.id.zdj1);

        itemView.setOnClickListener(this);
    }

    public void BindData(Repo repo) {
        name.setText(repo.getName());
        user.setText(repo.getUser());
        Glide.with(context)
                .load(repo.getAvatarUrl())
                .into(obr1);
        this.repo = repo;


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("repo", repo);
        context.startActivity(intent);

    }


    //todo 5: zaimplementuj viewholder


    //todo 9: dodaj funkcjonalność klikania na viewholder
    //todo 10.2: po kliknięciu prześlij do drugiej aktywności obiekt repo i wystartuj aktywnosc
}
