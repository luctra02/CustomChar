package customChar.core;

/**
 * CustomChar class.
 */
public class CustomChar {
    private String nickName;
    private String colour;
    private String gender;
    private String hair;
    private String extras;
    private String hairColour;

    /**
     * Initializes CustomChar.
     */
    public CustomChar() {
        gender = "Male";
        colour = "Black";
        nickName = "null";
        hair = "null";
        extras = "null";
        hairColour = "Brown";
    }

    public String getNickName() {
        return nickName;
    }

    /**
     * sets characters nickname.
     *
     * @param nickName the characters nickname
     */
    public void setNickName(String nickName) {
        if (nickName.equals("null")) {
            throw new IllegalArgumentException("Cannot be \"null\"");
        }
        if (!nickName.matches("[A-z-0-9]{3,13}")) {
            throw new IllegalArgumentException(
                    "Invalid username! Make sure the name is between 3-13 characters from a-z.");
        }
        

        this.nickName = nickName;
    }

    public String getColour() {
        return this.colour;
    }

    /**
     * returns characters hair colour.
     *
     * @return characters hair colour
     */
    public String getHairColour() {
        return this.hairColour;
    }

    /**
     * sets characters colour.
     *
     * @param colour the characters colour
     */
    public void setHairColour(String colour) {
        if (colour.equals("none")) {
            this.hairColour = "null";
        } else {
            this.hairColour = colour;
        }
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getGender() {
        return gender;
    }

    /**
     * sets characters gender.
     *
     * @param gender the characters gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHair() {
        return hair;
    }

    /**
     * sets characters hair.
     *
     * @param hair the characters hair
     */
    public void setHair(String hair) {
        if (hair.equals("none")) {
            this.hair = "null";
        } else {
            this.hair = hair;
        }

    }

    /**
     * returns characters extras.
     *
     * @return the characters extras
     */
    public String getExtras() {
        return extras;
    }

    /**
     * sets the characters extras.
     *
     * @param extras the characters extras
     */
    public void setExtras(String extras) {
        if (extras.equals("none")) {
            this.extras = "null";
        } else {
            this.extras = extras;
        }
    }
}