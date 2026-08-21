import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GitHub_Activity {
    public static void main(String[] args) throws Exception {

        /*
            Project Objective
            - Set up the CLI
            - Allow the user to enter their username through terminal
            - Fetch and retrieve GitHub API
            - Analyze the API and return value back to the user
         */

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

            if(response.body().equals("[]")) {
                System.out.println("Invalid or unable to find this username");
            } else {
                System.out.println(response.body());
            }

        } catch (IOException e) {
            System.out.println("Unable to access to this username" +
                    "\nThe username might be private for some reasons");
        } catch (InterruptedException e) {
            System.out.println("Something wrong");
        }

    }
}