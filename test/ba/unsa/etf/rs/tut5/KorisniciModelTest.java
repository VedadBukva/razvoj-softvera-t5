package ba.unsa.etf.rs.tut5;

import com.sun.javafx.binding.BidirectionalBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {
    private static final String OCEKIVANO_IME = "Ahmo";
    private static final String OCEKIVANO_PREZIME = "Ahmic";
    private static final String OCEKIVANI_MAIL = "Ahmed@gmail.com";
    private static final String OCEKIVANO_KORISNICKO_IME = "Ahmedinho";
    private static final String OCEKIVANA_LOZINKA = "abcd";

    @Test
    void getKorisnik() {
        KorisniciModel m = new KorisniciModel();
        m.napuni();
        assertNull(m.getTrenutniKorisnik());
    }

    @Test
    void setKorisnik() {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(OCEKIVANO_IME);
        korisnik.setPrezime(OCEKIVANO_PREZIME);
        korisnik.setMail(OCEKIVANI_MAIL);
        korisnik.setKorisnickoIme(OCEKIVANO_KORISNICKO_IME);
        korisnik.setLozinka(OCEKIVANA_LOZINKA);
        assertAll("Unos korisnika",
                () -> assertEquals(OCEKIVANO_IME,korisnik.getIme()),
                () -> assertEquals(OCEKIVANO_PREZIME,korisnik.getPrezime()),
                () -> assertEquals(OCEKIVANI_MAIL,korisnik.getMail()),
                () -> assertEquals(OCEKIVANO_KORISNICKO_IME,korisnik.getKorisnickoIme()),
                () -> assertEquals(OCEKIVANA_LOZINKA,korisnik.getLozinka())
        );
    }

    @Test
    void getTrenutniKorisnik() {
        KorisniciModel m = new KorisniciModel();
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(OCEKIVANO_IME);
        korisnik.setPrezime(OCEKIVANO_PREZIME);
        korisnik.setMail(OCEKIVANI_MAIL);
        korisnik.setKorisnickoIme(OCEKIVANO_KORISNICKO_IME);
        korisnik.setLozinka(OCEKIVANA_LOZINKA);
        m.setTrenutniKorisnik(korisnik);
        assertNotEquals("Rukfas",korisnik.getIme());
    }

    @Test
    void trenutniKorisnikProperty() {
        KorisniciModel m = new KorisniciModel();
        m.napuni();
        m.setTrenutniKorisnik(m.getKorisnik().get(0));
        assertEquals("Vedad",m.getTrenutniKorisnik().getIme());
    }

    @Test
    void setTrenutniKorisnik() {
        KorisniciModel m = new KorisniciModel();
        m.napuni();
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(OCEKIVANO_IME);
        korisnik.setPrezime(OCEKIVANO_PREZIME);
        korisnik.setMail(OCEKIVANI_MAIL);
        korisnik.setKorisnickoIme(OCEKIVANO_KORISNICKO_IME);
        korisnik.setLozinka(OCEKIVANA_LOZINKA);
        m.setTrenutniKorisnik(m.getKorisnik().get(0));
    }

    @Test
    void dodajKorisnika() {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme("Semso");
        korisnik.setPrezime("Poplava");
        korisnik.setMail("Semsudin@poplava.com");
        korisnik.setKorisnickoIme("noDi");
        korisnik.setLozinka("hehehe");
        assertAll("Novi korisnika",
                () -> assertNotEquals(OCEKIVANO_IME,korisnik.getIme()),
                () -> assertNotEquals(OCEKIVANO_PREZIME,korisnik.getPrezime()),
                () -> assertNotEquals(OCEKIVANI_MAIL,korisnik.getMail()),
                () -> assertNotEquals(OCEKIVANO_KORISNICKO_IME,korisnik.getKorisnickoIme()),
                () -> assertNotEquals(OCEKIVANA_LOZINKA,korisnik.getLozinka())
        );
    }

    @Test
    void napuniListu() {
        ObservableList<Korisnik> korisnik = FXCollections.observableArrayList();
        KorisniciModel model = new KorisniciModel();
    }
}