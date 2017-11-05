package pl.xdarekm.pogoda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-10-21.
 */

public class Baza_danych extends SQLiteOpenHelper {

    private static final int DB_Version = 2;
    private static final String DB_Name = "pogoda.db";
    private static final String DB_GIT_TABLE = "pogoda";
    private static final String KEY_CITY = "city";
    private static final String KEY_TEMP = "temp";
    private static final String Key_DATE = "date";
    private static final String KEY_IS_PRIVATE = "isPrivate";
    private static final String KEY_desc = "desc";
    private static final String KEY_icon = "icon";


    public Baza_danych(Context context) {

        super(context, DB_Name, null, DB_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POGODA_TABLE = " CREATE TABLE " + DB_GIT_TABLE +
                "(id  INTEGER PRIMARY KEY," + KEY_CITY + " TEXT," + KEY_TEMP + " REAL," + Key_DATE + " TEXT," +
                KEY_desc + " TEXT," + KEY_icon + " TEXT)";
        db.execSQL(CREATE_POGODA_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_GIT_TABLE);
        onCreate(db);
    }

    public void addRepo(Forcast repo) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CITY, repo.getCity());
        values.put(KEY_desc, repo.getDesc());
        values.put(KEY_TEMP, repo.getTemp());
        values.put(Key_DATE, repo.getDate());
        values.put(KEY_icon, repo.getIcon());

        db.insert(DB_GIT_TABLE, null, values);
        db.close();
    }

    public List<Forcast> getAllRepos() {
        List<Forcast> repos = new LinkedList<>();

        String selectQuery = "Select * FROM " + DB_GIT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Forcast repo = new Forcast();

                repo.setTemp(cursor.getDouble(2));
                repo.setCity(cursor.getString(1));
                repo.setDesc(cursor.getString(4));
                repo.setIcon(cursor.getString(5));
                repo.setDate(cursor.getString(3));
                repos.add(repo);
            } while (cursor.moveToNext());

        }
        db.close();
        return repos;
    }

    public void clearRepos() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + DB_GIT_TABLE);
        db.close();
    }
}