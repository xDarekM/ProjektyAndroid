package pl.xdarekm.pogoda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private TextView result;
    private EditText searchEt;
    private Button searchBtn;
    private ProgressBar progress;
    private RecyclerView recycler;
    private Button ustawienia;
    private String unit ="&units=metric";
    private List<Forcast> forcasts = new LinkedList<>();

    private final String Api_Key = "&AppID=69cdbc8b71e1f5b0818fed7c423f6e13";
    final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private final int loaderId = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        searchEt = (EditText) findViewById(R.id.search_et);
        searchBtn = (Button) findViewById(R.id.search_btn);
        progress = (ProgressBar) findViewById(R.id.progress);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        ustawienia = (Button) findViewById(R.id.Ustawienia);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutmanager);
        Decorator decorator = new Decorator(10);
        recycler.addItemDecoration(decorator);
        final LoaderManager.LoaderCallbacks<String> callbacks = this;
        getSupportLoaderManager().initLoader(loaderId, null, callbacks);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (czyjestInternet()) {
                    String query = BASE_URL + searchEt.getText().toString() + Api_Key + unit;
                    Uri uri = Uri.parse(query);
                    URL url = null;
                    try {
                        url = new URL(uri.toString());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    if (url != null) {

                        Bundle queryBundle = new Bundle();
                        queryBundle.putString("query", url.toString());

                        Loader<String> stringLoader = getSupportLoaderManager().getLoader(loaderId);

                        if (stringLoader == null) {
                            getSupportLoaderManager().initLoader(loaderId, queryBundle, callbacks);

                        } else {
                            getSupportLoaderManager().restartLoader(loaderId, queryBundle, callbacks);

                        }

                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Nie masz internetu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ustawienia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Aktywnosc.class);
                startActivity(intent);
            }
        });

    }

    public boolean czyjestInternet() {
        ConnectivityManager connectivitymanager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivitymanager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("pogoda", Activity.MODE_PRIVATE );
        String degrees = prefs.getString("degrees","c");

        if(degrees.equals("c")){
            unit = "&units=metric";
        } if(degrees.equals("f")){
            unit = "&units=imperial";
        } if(degrees.equals("k")){
            unit = "&units=default";
        }
        String cityString = prefs.getString("city","Warszawa");

        if (czyjestInternet()) {
            String query = BASE_URL + cityString + Api_Key + unit;
            Uri uri = Uri.parse(query);
            URL url = null;
            try {
                url = new URL(uri.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            if (url != null) {

                Bundle queryBundle = new Bundle();
                queryBundle.putString("query", url.toString());

                Loader<String> stringLoader = getSupportLoaderManager().getLoader(loaderId);

                if (stringLoader == null) {
                    getSupportLoaderManager().initLoader(loaderId, queryBundle, this);

                } else {
                    getSupportLoaderManager().restartLoader(loaderId, queryBundle, this);

                }

            }
        } else {
            Toast.makeText(getApplicationContext(), "Nie masz internetu", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<String>(this) {
            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                if (args == null) {
                    return;
                }
                progress.setVisibility(View.VISIBLE);
                result.setVisibility(View.INVISIBLE);
                forceLoad();
            }

            @Override
            public String loadInBackground() {
                String UrlString = args.getString("query");
                if (UrlString == null || UrlString.isEmpty()) {
                    return null;
                }

                try {
                    URL url = new URL(UrlString);
                    return Net_Utils.getResponseFromHttpUrl(url);

                } catch (IOException e) {
                    e.printStackTrace();
                    return null;

                }
            }
        };
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        progress.setVisibility(View.INVISIBLE);
        result.setVisibility(View.VISIBLE);

        if (data != null && !data.equals("")) {

            forcasts.clear();
            try {


                JSONObject in = new JSONObject(data);
                JSONObject cityobj = in.getJSONObject("city");
                String city = cityobj.getString("name");

                JSONArray arr = in.getJSONArray("list");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    String date = obj.getString("dt_txt");

                    JSONObject main = obj.getJSONObject("main");
                    Double temp = main.getDouble("temp");
                    JSONArray weatherArr = obj.getJSONArray("weather");
                    String desc = weatherArr.getJSONObject(0).getString("main");
                    String icon = weatherArr.getJSONObject(0).getString("icon");
                    Forcast f = new Forcast(city, date, desc, temp, icon);
                    forcasts.add(f);

                }
                weatherAdapter adapter = new weatherAdapter(getApplicationContext(), forcasts);
                recycler.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
                result.setText(e.toString());

            }

        }
    }


}
