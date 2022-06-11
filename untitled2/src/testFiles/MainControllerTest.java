package testFiles;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(ApplicationExtension.class)
class MainControllerTest {
    @Start
    public void start (Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("First.fxml"));
        stage.setTitle("Banking App");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        stage.toFront();
    }
    @Test
    public void testGoToStoreButton(FxRobot robot){
        Button btn = robot.lookup("#goToStore").queryAs(Button.class);
        assertNotNull(btn);
        robot.clickOn("#goToStore");
    }
    @Test
    public void testGoToBankButton(FxRobot robot){
        Button btn = robot.lookup("#goToBank").queryAs(Button.class);
        assertNotNull(btn);
        robot.clickOn("#goToBank");
    }
}