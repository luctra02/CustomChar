package customChar.ui;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import org.junit.jupiter.api.Assertions;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class AppTest extends ApplicationTest {
    private Controller controller;
    private Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("CustomChar.fxml"));
        root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void click(String button) {

        clickOn(LabeledMatchers.hasText(button));

    }

    /*
     * private Image getGenderImage(){
     * return getRootNode().lookup("#gender").
     * }m
     */

    @Test
    public void testColourButtons() {

        click("Pink");
        Assertions.assertEquals("Pink", controller.getColour());
        click("Green");
        Assertions.assertEquals("Green", controller.getColour());
        click("Purple");
        Assertions.assertEquals("Purple", controller.getColour());

    }

    @Test
    public void testHairColorButtons() {
        click("Hair");
        clickOn("#pinkButton1");
        Assertions.assertEquals("Pink", controller.getHairColour());
        clickOn("#greenButton1");
        Assertions.assertEquals("Green", controller.getHairColour());
        clickOn("#purpleButton1");
        Assertions.assertEquals("Purple", controller.getHairColour());
    }

    @Test
    public void testGenderButtons() {
        click("Gender");
        click("Male");
        Assertions.assertEquals("Male", controller.getGender());
        click("Gender");
        click("Female");
        Assertions.assertEquals("Female", controller.getGender());
    }

    @Test
    public void testHairButtons() {
        Assertions.assertEquals("null", controller.getHair());
        click("Hair");
        click("hair2");
        Assertions.assertEquals("hair2", controller.getHair());
        click("Hair");
        click("hair3");
        click("none");
        Assertions.assertEquals("null", controller.getHair());

    }

    @Test
    public void testExtrasButtons() {
        Assertions.assertEquals("null", controller.getExtras());
        click("Extras");
        click("tophat");
        Assertions.assertEquals("tophat", controller.getExtras());
        click("Extras");
        click("strawhat");
        Assertions.assertEquals("strawhat", controller.getExtras());
        click("Extras");
        click("wiz-hat");
        click("none");
        Assertions.assertEquals("null", controller.getExtras());

    }

    @Test
    public void testNickName(){
        clickOn("#nameValue").write("Iskandar");
        press(KeyCode.ENTER);
        Assertions.assertEquals("Iskandar", controller.getNameValue());
    }



}
