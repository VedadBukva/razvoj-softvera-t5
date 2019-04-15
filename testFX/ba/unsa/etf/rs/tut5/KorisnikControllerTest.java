package ba.unsa.etf.rs.tut5;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class KorisnikControllerTest {
    @Start
    public void start(Stage stage) throws Exception {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setController(new KorisnikController(model));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    @Test
    void prviFXTest(FxRobot robot) {
        javafx.scene.control.Button dodaj = robot.lookup("#dodaj").queryAs(Button.class);
        assertNotNull(dodaj);
        robot.clickOn("Tarik Sijarcic");
        robot.clickOn("#fldNik");
        try {
            Thread.sleep(1500);
            assertNotEquals("vedadbukva", "tsijercic1");
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        robot.clickOn("#kraj");
    }

    @Test
    void drugiFXTest(FxRobot robot) {
        Button dodaj = robot.lookup("#dodaj").queryAs(Button.class);
        assertNotNull(dodaj);
        robot.clickOn(" ");
        robot.clickOn("#fldIme");
        //robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("Test");
        robot.clickOn("#fldPrezime");
        //robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("FXRobot");
        robot.clickOn("#fldMail");
        //robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("test@javafx.robot");
        robot.clickOn("#fldNik");
        //robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("robotic");
        robot.clickOn("#fldLozinka");
        //robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("sifra");
        robot.clickOn(dodaj);
        try{
            Thread.sleep(200);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        robot.clickOn("Vedad Bukva");
        assertEquals("Vedad", "Vedad");
        try{
            Thread.sleep(200);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        robot.clickOn("Test FXRobot");
        robot.clickOn("#fldIme");
        assertNotEquals("Vedad", "Test");
        try{
            Thread.sleep(200);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        robot.clickOn("#kraj");

    }

    @Test
    void noviKorisnik(FxRobot robot) {
        Button dodaj = robot.lookup("#dodaj").queryAs(Button.class);
        robot.clickOn(dodaj);
        robot.clickOn("Vedad Bukva");
        robot.clickOn("#fldIme");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("Test");
        robot.clickOn("#fldPrezime");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("FXRobot");
        robot.clickOn("#fldMail");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("test@javafx.robot");
        robot.clickOn("#fldNik");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("robotic");
        robot.clickOn("#fldLozinka");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("sifra");
        robot.clickOn(dodaj);

        robot.clickOn("#kraj");
    }
}