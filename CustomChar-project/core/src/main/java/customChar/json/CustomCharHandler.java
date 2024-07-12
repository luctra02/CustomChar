package customChar.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import customChar.core.CustomChar;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

/**
 * Saves and loads the customChar object via a rest server.
 */
public class CustomCharHandler {
    private static final String APPLICATION_JSON = "application/json";
    private static final String ACCEPT_HEADER = "Accept";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * sends the customchar object to the rest server in a http post request.
     *
     * @param nickName   the character nickname
     * @param customChar the customchar object to be saved
     */
    public void writeCustomCharState(String nickName, CustomChar customChar) throws Exception {
        if (nickName.equals("null")) {
            throw new FileNotFoundException();
        }
        try {
            String json = mapper.writeValueAsString(customChar);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/customChar/save/").resolve(nickName))
                    .header(ACCEPT_HEADER, APPLICATION_JSON)
                    .header(CONTENT_TYPE_HEADER, APPLICATION_JSON)
                    .POST(BodyPublishers.ofString(json))
                    .build();
            HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * loads the customchar object with the same nickname.
     *
     * @param nickName the character nickname
     * @return the customchare object stored at nickname.txt
     * @throws FileNotFoundException if the rest server fails to load the file
     */
    public CustomChar readCustomCharState(String nickName) throws Exception {
        if (nickName.equals("null")) {
            throw new FileNotFoundException();
        }

        final CustomChar customChar;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/customChar/").resolve(nickName))
                .header(ACCEPT_HEADER, APPLICATION_JSON)
                .GET()
                .build();

        try {
            final HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
                    HttpResponse.BodyHandlers.ofString());
            customChar = mapper.readValue(response.body(), CustomChar.class);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

        return customChar;
    }
}
