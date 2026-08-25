import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class GitHub_Activity {
    public static void main(String[] args) throws Exception {

        /*
            Project Objective
            - Set up the CLI
            - Allow the user to enter their username through terminal
            - Fetch and retrieve GitHub API
            - Analyze the API and return value back to the user
         */
        // Version 1
        /*
        try {

            String username = args[0];

            if (args.length == 1) {
                System.out.println("Username: " + username);
                API(username);
            } else if (username.equals("")) {
                System.out.println("Invalid username or empty");
            } else if (args.length >= 2) {
                System.out.println("Stop");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of bound, Please try again!");
            System.out.println("Please enter your GitHub username");
            System.out.println("Run the command again to enter. Thank You!");
        }

         */

        if(args.length == 0) {
            System.out.println("Empty username");
        } else if (args.length > 1) {
            System.out.println("Out of bound, Please try again!");
        } else {
            String username = args[0];
            if(username.isBlank()) {
                System.out.println("Please enter your GitHub's username correctly");
            } else {
                clientUsername(username);
            }
        }




    }

    private static void clientUsername(String username) {

        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        GitHubAPI gitHub = new GitHubAPI(client, mapper);

        System.out.println(gitHub.getProfile(username).get("repos_url"));
        System.out.println(gitHub.getEvents(username).get(0).get("type"));
        System.out.println(gitHub.getRepos(username).get(0));

    }

}