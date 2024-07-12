package customChar.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CustomCharTest {

    private CustomChar customChar;

    @BeforeEach
    public void setup() {
        customChar = new CustomChar();
    }

    @Test
    public void testSetAndGetColour(){
        customChar.setColour("Pink");
        assertEquals("Pink", customChar.getColour());
    }

    @Test
    public void testSetAndGetGender(){
        customChar.setGender("Female");
        assertEquals("Female", customChar.getGender());


    }

    @Test
    public void testSetAndGetHair(){
        customChar.setHair("hair4");
        assertEquals("hair4", customChar.getHair());
        customChar.setHair("none");
        assertEquals("null", customChar.getHair());


    }

    @Test
    public void testSetAndGetHairColour(){
        customChar.setHairColour("Red");
        assertEquals("Red", customChar.getHairColour());
        customChar.setHairColour("none");
        assertEquals("null", customChar.getHairColour());


    }

    @Test
    public void testSetAndGetExtras(){
        customChar.setExtras("strawhat");
        assertEquals("strawhat", customChar.getExtras());
        customChar.setExtras("none");
        assertEquals("null", customChar.getExtras());


    }

    private void testInvalidNickName(String InvalidNickName) {
        assertThrows(IllegalArgumentException.class, () -> {
            customChar.setNickName(InvalidNickName);
        }, "IllegalArgumentException skal utløses når det ikke er alfa-numeriske tegn i brukernavnet, eller hvis brukernavnet er mindre enn 3 tegn eller større enn 13 tegn");
    }

    @Test
    public void testSetAndGetNickname() throws Exception {
        testInvalidNickName("Ol");
        testInvalidNickName("OlaNordmann12345");
        testInvalidNickName("Ol,a");
        assertDoesNotThrow(() -> 
        customChar.setNickName("OlaNordmann"));
        customChar.setNickName("OlaNordmann");
        assertEquals("OlaNordmann", customChar.getNickName());
    }
}
