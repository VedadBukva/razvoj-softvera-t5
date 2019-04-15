package ba.unsa.etf.rs.tut5;

import com.sun.javafx.binding.BidirectionalBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {
    private static KorisniciModel m = null;

    private static final String OCEKIVANO_IME = "Ahmo";
    private static final String OCEKIVANO_PREZIME = "Ahmic";
    private static final String OCEKIVANI_MAIL = "Ahmed@gmail.com";
    private static final String OCEKIVANO_KORISNICKO_IME = "Ahmedinho";
    private static final String OCEKIVANA_LOZINKA = "abcd";

    @BeforeAll
    static void setup() {
        m = new KorisniciModel();
        m.napuni();
    }

    @Test
    void getKorisnik() {
        m.dodajKorisnika();
        assertEquals(4, m.getKorisnik().size());
    }

    @Test
    void setKorisnik() {
        /*Korisnik korisnik = new Korisnik();
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
        );*/
    }

    @Test
    void getTrenutniKorisnik() {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(OCEKIVANO_IME);
        korisnik.setPrezime(OCEKIVANO_PREZIME);
        korisnik.setMail(OCEKIVANI_MAIL);
        korisnik.setKorisnickoIme(OCEKIVANO_KORISNICKO_IME);
        korisnik.setLozinka(OCEKIVANA_LOZINKA);
        m.setTrenutniKorisnik(korisnik);
        assertEquals(korisnik,m.getTrenutniKorisnik());
    }

    @Test
    void trenutniKorisnikProperty() {

    }

    @Test
    void setTrenutniKorisnik() {
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
        ObservableList<Korisnik> x = m.getKorisnik();
        x.add(new Korisnik("Hara", "Mali", "hahah@haha.com", "sada", "jupi"));
        assertNotEquals(7,m.getKorisnik().size());

        /*Korisnik korisnik = new Korisnik();
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
        );*/
    }

    @Test
    void napuniListu() {
        ObservableList<Korisnik> korisnik = m.getKorisnik();
        korisnik.add(new Korisnik("Hara", "Mali", "hahah@haha.com", "sada", "jupi"));
        assertNotEquals(4,m.getKorisnik().size());

    }
}