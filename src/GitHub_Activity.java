import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        /*
            Project Objective
            - Set up the CLI
            - Allow the user to enter their username through terminal
            - Fetch and retrieve GitHub API
            - Analyze the API and return value back to the user
         */

        String username = args[0];

        if(username.equals(" ") && args.length == 1) {
            System.out.println("Please enter your GitHub username");
            System.out.println("Run the command again to enter. Thank You!");
            return;
        } else if (args.length == 2) {
            throw new Exception("Out of bound, Please try again");
        } else {
            System.out.println(username);
        }







        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/Dark-ight/events"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

        } catch (IOException e) {
            System.out.println("Something wrong happened");
        } catch (InterruptedException e) {
            System.out.println("Something wrong");
        }

    }
}