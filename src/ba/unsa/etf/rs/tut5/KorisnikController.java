package ba.unsa.etf.rs.tut5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class KorisnikController {

    public ListView      lista;
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldMail;
    public TextField fldNik;
    public PasswordField fldLozinka;
    public Button kraj;
    public Button dodaj;

    private KorisniciModel korisniciModel;


    public KorisnikController(KorisniciModel m) {
        korisniciModel = m;
    }

    @FXML
    public void zatvori(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void dodaj(ActionEvent actionEvent) {
        korisniciModel.dodajKorisnika();
        odvezivanje();
        korisniciModel.setTrenutniKorisnik(korisniciModel.getKorisnik().get(korisniciModel.getKorisnik().size()-1));
        povezivanje();
        lista.refresh();
    }

    private void odvezivanje() {
        fldIme.textProperty().unbindBidirectional(korisniciModel.getTrenutniKorisnik().imeProperty());
        fldPrezime.textProperty().unbindBidirectional(korisniciModel.getTrenutniKorisnik().prezimeProperty());
        fldMail.textProperty().unbindBidirectional(korisniciModel.getTrenutniKorisnik().mailProperty());
        fldNik.textProperty().unbindBidirectional(korisniciModel.getTrenutniKorisnik().korisnickoImeProperty());
        fldLozinka.textProperty().unbindBidirectional(korisniciModel.getTrenutniKorisnik().lozinkaProperty());
    }

    private void povezivanje() {
        fldIme.textProperty().bindBidirectional(korisniciModel.getTrenutniKorisnik().imeProperty());
        fldPrezime.textProperty().bindBidirectional(korisniciModel.getTrenutniKorisnik().prezimeProperty());
        fldMail.textProperty().bindBidirectional(korisniciModel.getTrenutniKorisnik().mailProperty());
        fldNik.textProperty().bindBidirectional(korisniciModel.getTrenutniKorisnik().korisnickoImeProperty());
        fldLozinka.textProperty().bindBidirectional(korisniciModel.getTrenutniKorisnik().lozinkaProperty());
    }

    @FXML
    public void initialize() {
        korisniciModel.setTrenutniKorisnik(korisniciModel.getKorisnik().get(0));
        povezivanje();
        lista.setItems(korisniciModel.getKorisnik());
        lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik stariKorisnik, Korisnik noviKorisnik) {
                if(stariKorisnik!=null) {
                    odvezivanje();
                }
                if (noviKorisnik == null) {
                    fldIme.setText("");
                    fldPrezime.setText("");
                    fldMail.setText("");
                    fldNik.setText("");
                    fldLozinka.setText("");
                }
                else {
                    Korisnik korisnik =  (Korisnik) lista.getSelectionModel().getSelectedItem();
                    odvezivanje();
                    korisniciModel.setTrenutniKorisnik(korisnik);
                    povezivanje();
                    lista.refresh();
                }
                lista.refresh();
            }
        });
    }
}