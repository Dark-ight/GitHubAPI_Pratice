import java.net.http.HttpClient;

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
                userDisplay(username);
            }
        }
    }

    private static void userDisplay(String username) throws NullPointerException{
        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();
            GitHubAPI gitHub = new GitHubAPI(client, mapper);

            JsonNode profile = gitHub.getProfile(username);
            JsonNode repos = gitHub.getRepos(username);
            JsonNode events = gitHub.getEvents(username);


            String loginName = gitHub.getProfile(username).get("login").asText();
            String reposNum = gitHub.getProfile(username).get("public_repos").asText();

            String[] typeArray = new String[2];
            String[] repoArray = new String[gitHub.getProfile(username).get("public_repos").asInt()];
            int[] countArray = new int[gitHub.getProfile(username).get("public_repos").asInt()];

            //Load repos into array - done
            for (int i = 0; i < gitHub.getRepos(username).size(); i++) {
                repoArray[i] = gitHub.getRepos(username).get(i).get("full_name").asText();
                System.out.println(repoArray[i]);
            }
            System.out.println(gitHub.getEvents(username).size());


            for (int i = 0; i < gitHub.getEvents(username).size(); i++) {
                for (int j = 0; j < repoArray.length; j++) {
                    if (gitHub.getEvents(username).get(i).get("repo").get("name").asText().equals(repoArray[j]) &&
                            gitHub.getEvents(username).get(i).get("type").asText().equals("PushEvent")) {
                        countArray[j]++;
                    }
                }
            }

            for (int i = 0; i < gitHub.getRepos(username).size(); i++) {
                System.out.println("This user pushed " + repoArray[i] + " commits on this " + repoArray[i]);
            }

            System.out.println("Username: " + loginName);
            System.out.println("Total public repositories: " + reposNum);

        } catch (NullPointerException e) {

            System.out.println("The field in the response may not exist or something wrong with your API");
        }

    }

}