import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;


public class GitHub_Activity {
    public static void main(String[] args) throws Exception {

        if(args.length == 0) {
            System.out.println("Empty username");
        } else if (args.length > 1) {
            System.out.println("Out of bound, Please try again!");
        } else {
            String username = args[0];
            if(username.isBlank()) {
                System.out.println("Please enter your GitHub's username correctly");
            } else {
                userDisplay(username);
            }
        }
    }

    private static void userDisplay(String username) {
        String loginName = null;
        String reposNum = null;
        String name = null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();
            GitHubAPI gitHub = new GitHubAPI(client, mapper);

            JsonNode profile = gitHub.getProfile(username);
            JsonNode repos = gitHub.getRepos(username);
            JsonNode events = gitHub.getEvents(username);

            loginName = profile.path("login").asText();
            reposNum = profile.path("public_repos").asText();
            name = profile.path("name").asText();
            String[] repoArray = new String[repos.size()];
            int[] countArray = new int[repos.size()];

            //Load repos into array - done
            for (int i = 0; i < repos.size(); i++) {
                repoArray[i] = repos.path(i).path("full_name").asText();
            }

            //Parallel Array
            for (int i = 0; i < events.size(); i++) {
                for (int j = 0; j < repoArray.length; j++) {
                    if (events.path(i).path("repo").path("name").asText().equals(repoArray[j]) &&
                            events.get(i).path("type").asText().equals("PushEvent")) {
                        countArray[j]++;
                    }
                }
            }

            System.out.println("<______________________Display/Info______________________>");
            System.out.println("Username: " + loginName);
            System.out.println("Name: " + name);
            System.out.println("Total public repositories: " + reposNum);
            System.out.println("<_________________________Events_________________________>");
            for (int i = 0; i < repos.size(); i++) {
                if (countArray[i] != 0) {
                    System.out.println("This user pushed " + countArray[i] + " commits on this " + repoArray[i]);
                }
            }

            System.out.println("<__________________________END___________________________>");
        } catch (NullPointerException e) {
            System.out.println("<______________________Display/Info______________________>");
            System.out.println("Username: " + loginName);
            System.out.println("Name: " + name);
            System.out.println("Total public repositories: " + reposNum);
            System.out.println("<_________________________Events_________________________>");
            System.out.println("None 'PushEvent' was found");
            System.out.println("<__________________________END___________________________>");
        }
    }

}