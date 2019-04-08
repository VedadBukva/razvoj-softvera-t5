package ba.unsa.etf.rs.tut5;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KorisnikController {


    public ListView lista;
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldMail;
    public TextField fldNik;
    public PasswordField fldLozinka;
    public Button kraj;

    public void zatvori(ActionEvent actionEvent) {
        Stage stage = (Stage) kraj.getScene().getWindow();
        stage.close();
    }
}
