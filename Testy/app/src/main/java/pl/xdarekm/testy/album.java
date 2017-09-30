package pl.xdarekm.testy;

/**
 * Created by uczen on 2017-09-30.
 */

public class album {
    private  String tytuł;
    private String data_wydania;
    private String autor;
    private int id_okladki;

    public album(String tytuł,String data_wydania,String  autor,int id_okladki  ){

        this.setTytuł(tytuł);
        this.setData_wydania(data_wydania);
        this.setAutor(autor);
        this.setId_okladki(id_okladki);
    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    public String getData_wydania() {
        return data_wydania;
    }

    public void setData_wydania(String data_wydania) {
        this.data_wydania = data_wydania;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId_okladki() {
        return id_okladki;
    }

    public void setId_okladki(int id_okladki) {
        this.id_okladki = id_okladki;
    }
}