package pl.atk.szkolenietest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Tomasz on 04.11.2017.
 */

public class SecondActivity extends AppCompatActivity {

    //todo 11: odbierz intent
    private ImageView zdj1;
    private TextView Name;
    private TextView User;
    private TextView Clone;
    private TextView Date;
    private TextView Language;
    private TextView Size;
    private TextView Watchers;
    private TextView Story;


    //todo 12: przypisz dane do komponentów

    private Repo repo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        zdj1 = (ImageView) findViewById(R.id.obr1);
        Name = (TextView) findViewById(R.id.text1);
        User = (TextView) findViewById(R.id.text2);
        Clone = (TextView) findViewById(R.id.text4);
        Date = (TextView) findViewById(R.id.text6);
        Language = (TextView) findViewById(R.id.text8);
        Size = (TextView) findViewById(R.id.text10);
        Watchers = (TextView) findViewById(R.id.text12);
        Story = (TextView) findViewById(R.id.text13);

        Intent intent = getIntent();
        if (intent != null) {
            repo = (Repo) intent.getSerializableExtra("repo");
        }

        if(repo !=null){
            Name.setText(repo.getName());
            User.setText(repo.getUser());
            Clone.setText(repo.getCloneUrl());
            Date.setText(repo.getCreatedDate());
            Language.setText(repo.getLanguage());
            Size.setText(repo.getSize()+"");
            Watchers.setText(repo.getWatchers()+"");
            Story.setText(repo.getDesc());

            Glide.with(this)
                    .load(repo.getAvatarUrl())
                    .into(zdj1);
        }
    }





}