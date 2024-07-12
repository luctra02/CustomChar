package customChar.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javafx.scene.effect.ColorAdjust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChangeColorTest {

    private ColorAdjust ColorAdjust = null;
    private ChangeColor color;

    @BeforeEach
    public void setup() {
        color = new ChangeColor();
        ColorAdjust = new ColorAdjust();
    }

    @Test
    public void checkBlackHue() {
        ColorAdjust.setBrightness(0);
        assertEquals(0.0, color.getHue("Black").getBrightness());
    }

    @Test
    public void checkAnyOtherHue() {
        assertEquals(-0.08, color.getHue("Red").getHue());
    }

    
}
