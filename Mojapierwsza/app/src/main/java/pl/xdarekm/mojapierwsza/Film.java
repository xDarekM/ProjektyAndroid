package pl.xdarekm.mojapierwsza;

/**
 * Created by uczen on 2017-09-24.
 */

public class Film {
    private String title;
    private int length;
    public Film(String title, int length ){
        this.setTitle(title);
        this.setLength(length);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
