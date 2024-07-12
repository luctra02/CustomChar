package customChar.ui;

import customChar.core.CustomChar;
import customChar.json.CustomCharHandler;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
* Controller for the application.
*/
public class Controller {

    @FXML
    private AnchorPane colourTable, genderTable, hairTable, extrasTable;

    @FXML
    private Button colourButton, genderButton, hairButton, extrasButton;

    @FXML
    private GridPane imageGridPane;

    @FXML
    private ImageView genderView, hairView;

    @FXML
    private TextField nameValue;

    @FXML
    private ImageView extrasView;
    private AnchorPane[] tables;
    private Button[] buttons;
    private CustomChar customChar;
    private CustomCharHandler customCharHandler;
    private ChangeColor changeColor;

    /**
    * Initializes the customChar, changeColor, and customCharHandler classes.
    */
    public Controller() {
        customChar = new CustomChar();
        changeColor = new ChangeColor();
        customCharHandler = new CustomCharHandler();
    }

    public String getHair() {
        return customChar.getHair();
    }

    public String getExtras() {
        return customChar.getExtras();
    }

    public String getColour() {
        return customChar.getColour();
    }

    public String getGender() {
        return customChar.getGender();
    }

    public String getNameValue() {
        return nameValue.getText();
    }
    
    public String getHairColour() {
        return customChar.getHairColour();
    }

    public void initialize() {
        updateImage();
    }

    @FXML
    void changeTableToColourPicker() {
        changeTable(colourTable);
    }

    @FXML
    void changeTableToGenderPicker() {
        changeTable(genderTable);
    }

    @FXML
    void changeTableToHairPicker() {
        changeTable(hairTable);
    }

    @FXML
    void changeTableToExtrasPicker() {
        changeTable(extrasTable);
    }

    @FXML
    void changeName(ActionEvent event) {
        try {
            customChar.setNickName(nameValue.getText());
        } catch (IllegalArgumentException e) {
            showErrorMessage(e.getMessage());
        }
    }

    /**
     * Shows the table of options that the user clicked on and makes the other 3
     * tables invisible.
     *
     * @param table the table of options that we want to show to the user
     */
    private void changeTable(AnchorPane table) {
        tables = new AnchorPane[] { colourTable, genderTable, hairTable, extrasTable };
        buttons = new Button[] { colourButton, genderButton, hairButton, extrasButton };

        for (int i = 0; i < 4; i++) {
            if (tables[i] != table) {
                tables[i].setVisible(false);
                buttons[i].setOpacity(0.5);
            } else {
                table.setVisible(true);
                buttons[i].setOpacity(1);
            }
        }
    }

    /**
     * Finds the text on the button that the user clicked and sends it
     * to the customChar object to be stored.
     *
     * @param event the onAction event from a user clicking on a button
     */
    @FXML
    void changeColour(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String colour = sourceButton.getText();
        customChar.setColour(colour);
        updateImage();
    }

    @FXML
    void changeHairColour(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String hairColour = sourceButton.getText();
        customChar.setHairColour(hairColour);
        updateImage();
    }

    @FXML
    void changeGender(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String gender = sourceButton.getText();
        customChar.setGender(gender);
        updateImage();
    }

    @FXML
    void changeHair(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String hair = sourceButton.getText();
        customChar.setHair(hair);
        updateImage();
    }

    @FXML
    void changeExtras(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String extras = sourceButton.getText();
        customChar.setExtras(extras);
        updateImage();
    }

    /**
     * Empties the gridpane of the previous images.
     * Adds the gender, hair and extras images in order so the
     * hat shows up on top of the hair. Changes the colour of the gender
     * image to what the user specified. User values are taken from
     * the customChar object.
     */
    @FXML
    void updateImage() {
        imageGridPane.getChildren().clear();

        if (!customChar.getGender().equals("null")) {
            Image gender = new Image(
                getClass().getResourceAsStream("images/genders/" + customChar.getGender() + ".png"));
            genderView = new ImageView(gender);
            imageGridPane.add(genderView, 0, 1);
            genderView.setEffect(changeColor.getHue(customChar.getColour()));
        }
        if (!customChar.getHair().equals("null")) {
            Image hair = new Image(
                    getClass().getResourceAsStream("images/hair/" + customChar.getHair() + ".png"));
            hairView = new ImageView(hair);
            imageGridPane.add(hairView, 0, 1);
            hairView.setEffect(changeColor.getHue(customChar.getHairColour()));
        }
        if (!customChar.getExtras().equals("null")) {
            Image extras = new Image(
                getClass().getResourceAsStream("images/extras/" + customChar.getExtras() + ".png"));
            extrasView = new ImageView(extras);
            imageGridPane.add(this.extrasView, 0, 1);
        }
    }

    /**
     * Loads the uservalues to the customChar object from a file named nickname.txt
     * Updates the image shown to the user with the user values collected from the file.
     *
     * @throws FileNotFoundException if there is no file with that nickname
     */
    @FXML
    private void loadState() {
        try {
            customChar = customCharHandler.readCustomCharState(customChar.getNickName());
        } catch (ConnectException e) {
            showErrorMessage("Make sure springboot is running!");
        } catch (FileNotFoundException e) {
            showErrorMessage("Nickname cannot be null, press enter to save nickname");
        } catch (Exception e) {
            showErrorMessage("File doesn't exist for this name: " + customChar.getNickName());
        }
        updateImage();

    }

    /**
     * Saves the data in the customChar object in a file named nickname.txt
     *
     * @throws FileNotFoundException if there is an error in creating the file or
     *                               finding the existing file with the same name
     */
    @FXML
    private void saveState() {
        try {
            customCharHandler.writeCustomCharState(customChar.getNickName(), customChar);
        } catch (FileNotFoundException e) {
            showErrorMessage("Need to specify a name before saving. Press enter to confirm nickname");
        } catch (Exception e) {
            showErrorMessage("Remember to open a new terminal and run springboot! (Check readme.txt)");
        }
    }

    /**
     * Shows the user a popup with the errormessage.
     *
     * @param errorMessage a description for why there ocurred an error
     */
    private void showErrorMessage(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(errorMessage);
        alert.showAndWait();
    }

}