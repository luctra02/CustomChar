package customChar.springboot.restserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import customChar.core.CustomChar;
import java.io.File;
import java.io.FileNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The service implementation.
 */

@RestController
@RequestMapping(CustomCharModelController.CUSTOMCHAR_MODEL_SERVICE_PATH)
public class CustomCharModelController {

    public static final String CUSTOMCHAR_MODEL_SERVICE_PATH = "customChar";
    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping
    public CustomChar getCustomChar() {
        return new CustomChar();
    }

    /**
    * Gets the corresponding customChar.
    *
    * @param nickName the name of the customChar
    * @return the corresponding customChar
    */
    @GetMapping(path = "/{nickName}")
    public CustomChar getCustomChar(@PathVariable("nickName") String nickName) throws FileNotFoundException {
        CustomChar customChar;

        try {
            customChar = mapper.readValue(getFile(nickName), CustomChar.class);
        } catch (Exception e) {
            throw new FileNotFoundException();
        }

        return customChar;
    }

    /**
     * Saves the customChar-object to a file named nickName.json.
     *
     * @param nickName character's nickname
     * @param customChar CustomChar-object that you want to save
     * @throws FileNotFoundException if it fails to write the file
     */
    @PostMapping(path = "/save/{nickName}")
    public void saveCustomChar(@PathVariable("nickName") String nickName, @RequestBody CustomChar customChar)
        throws FileNotFoundException {
        try {
            mapper.writeValue(getFile(nickName), customChar);
        } catch (Exception e) {
            throw new FileNotFoundException();
        }
    }

    /**
     * creates a file with relative path from fxui to the save file and creates a
     * parent folder if it doesnt exist to store multiple saves.
     *
     * @param filename the nickname to use as filename
     * @return the file object
     */
    private static File getFile(String filename) {
        File file = new File("../../core/src/main/java/customChar/core/CustomCharSaves/" + filename + ".json");
        if (file.getParentFile().mkdir()) {
            ;
        }
        return file;
    }
}