import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubAPI {

    private final HttpClient client;
    private final ObjectMapper mapper;

    public GitHubAPI(HttpClient client, ObjectMapper mapper) {
        this.client = client;
        this.mapper = new ObjectMapper();
    }

    public JsonNode getProfile(String username) {
        JsonNode root = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/" + username))
                    .GET().
                    build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println("Profile: " + response.statusCode());
            if (response.statusCode() == 404) {
                System.out.println("Invalid username");
            } else if (response.statusCode() == 200) {
                if (response.body().equals("[]")) {
                    System.out.println("No recent activity from this username");
                } else {
                    root = mapper.readTree(response.body());
                }
            } else if (response.statusCode() == 403) {
                System.out.println("Sorry, your API had hit rate limits");
            }

        } catch (IOException e) {
            System.out.println("Something wrong with the input and output");
        } catch (InterruptedException e) {
            System.out.println("The response got interrupted");
        }

        return root;
    }

    public JsonNode getEvents(String username) {
        JsonNode root = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/" + username + "/events"))
                    .GET().
                    build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println("Events: " + response.statusCode());
            if (response.statusCode() == 404) {
                System.out.println("Invalid username");
            } else if (response.statusCode() == 200) {
                if (response.body().equals("[]")) {
                    System.out.println("- No recent activity from this username");
                } else {
                    root = mapper.readTree(response.body());
                }
            } else if (response.statusCode() == 403) {
                System.out.println("- Sorry, your API had hit rate limits");
            }

        } catch (IOException e) {
            System.out.println("Something wrong with the input and output");
        } catch (InterruptedException e) {
            System.out.println("The response got interrupted");
        }

        return root;
    }

    public JsonNode getRepos(String username) {
        JsonNode root = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/" + username + "/repos"))
                    .GET().
                    build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println("Repos: " + response.statusCode());
            if (response.statusCode() == 404) {
                System.out.println("Invalid username");
            } else if (response.statusCode() == 200) {
                if (response.body().equals("[]")) {
                    System.out.println("- No recent activity from this username");
                } else {
                    root = mapper.readTree(response.body());
                }
            } else if (response.statusCode() == 403) {
                System.out.println("- Sorry, your API had hit rate limits");
            }

        } catch (IOException e) {
            System.out.println("Something wrong with the input and output");
        } catch (InterruptedException e) {
            System.out.println("The response got interrupted");
        }

        return root;
    }


}
