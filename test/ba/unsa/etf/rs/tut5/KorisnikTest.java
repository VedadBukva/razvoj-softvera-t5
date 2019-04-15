package ba.unsa.etf.rs.tut5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisnikTest {
    private static Korisnik korisnik = null;

    @BeforeAll
    static void setup() {
        korisnik = new Korisnik("ime", "prezime", "asad", "asdasd", "sadasdas");
    }

    @Test
    void getIme() {
        String ime = "IME";
        korisnik.setIme(ime);
        assertEquals("IME", korisnik.getIme());

    }

    @Test
    void dummy() {
    }

}