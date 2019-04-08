package ba.unsa.etf.rs.tut5;

import javafx.beans.property.SimpleObjectProperty;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnik = FXCollections.observableArrayList();
    private SimpleObjectProperty trenutniKorisnik = new SimpleObjectProperty();

    public ObservableList<Korisnik> getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(ObservableList<Korisnik> korisnik) {
        this.korisnik = korisnik;
    }

    public Object getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Object trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    void napuni (){
        korisnik.add(new Korisnik( "Vedad" , "Bukva" , " vbukva1@etf.unsa.ba" , "vbukva1", "password"));
        korisnik.add(new Korisnik( "Tarik" , "Sijarcic" , " tsijarcic1@etf.unsa.ba" , "tsijercic1", "lozinka"));
    }

}