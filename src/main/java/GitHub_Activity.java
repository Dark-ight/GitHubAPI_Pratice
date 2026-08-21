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
                API(username);
            }
        }

    }

    private static void API(String username) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/" + username + "/events"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: " + response.statusCode());
            if (response.statusCode() == 404) {
                System.out.println("Invalid username");
            } else if (response.statusCode() == 200) {
                if (response.body().equals("[]")) {
                    System.out.println("Unable to find information of this username");
                    System.out.println("No recent activity from this username");
                } else {
                    UserInfo(response);
                }
            }



        } catch (IOException e) {
            System.out.println("Unable to access to this username" +
                    "\nThe username might be private for some reasons");
        } catch (InterruptedException e) {
            System.out.println("The request was interrupted");
        }
    }

    private static void UserInfo(HttpResponse<String> response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            int count = 0;
            for(int i = 0; i < root.size(); i++) {
                System.out.println(root.get(i).get("type"));
                if(root.get(i).get("type").equals("'PushEvent'")) {
                    System.out.println("Hello");
                }
            }
            System.out.println(root.get(0).get("type").equals("'PushEvent'"));





        } catch (JsonProcessingException e) {
            System.out.println("Something wrong during processing");
        }
    }



}