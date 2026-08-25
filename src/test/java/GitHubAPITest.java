import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GitHubAPITest {

    @Test
    void testSomething() {
        System.out.println("JUnit works!");
    }

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private final GitHubAPI gitHub = new GitHubAPI(client, mapper);

    @Test
    void getProfile_returnsCorrectUser() {

        JsonNode profile = gitHub.getProfile("Dark-ight");

        assertEquals(
                "Dark-ight",
                profile.path("login").asText()
        );
    }
}