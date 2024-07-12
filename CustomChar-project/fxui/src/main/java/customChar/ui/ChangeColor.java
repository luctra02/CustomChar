package customChar.ui;

import java.util.Map;
import javafx.scene.effect.ColorAdjust;


/**
*Class for changing hair- and charactercolor.
*/
public class ChangeColor {

    private ColorAdjust colorAdjust = new ColorAdjust();

    /**
    *returns a colorAdjust object with changed hues 
    *and brightness to be used to applied to a black image.
    *
    *@param colour takes in a string of a color
    */
    public ColorAdjust getHue(String colour) {
        colorAdjust = new ColorAdjust();
        // Map containing the hue values of colors
        Map<String, Double> hueValues = Map.of(
                "Red", -0.08,
                "Blue", -0.76,
                "Green", 0.7,
                "Pink", -0.25,
                "Purple", -0.45,
                "Brown", 0.08,
                "Yellow", 0.24);
        // changes the "adjustment" setting
        if (colour.equals("Black")) {
            colorAdjust.setBrightness(0);
        } else {
            colorAdjust.setHue(hueValues.get(colour));
            colorAdjust.setBrightness(0.5);
            colorAdjust.setSaturation(1);
        }

        return colorAdjust;
    }
}
