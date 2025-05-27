import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GitHubUserFetcher {
    public static void main(String[] args) {
        String username = "koushika31";
        String url = "https://api.github.com/users/" + username;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body:\n" + response.body());

            // Parse JSON using Gson
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            System.out.println("\nParsed Data:");
            System.out.println("Login: " + json.get("login").getAsString());
            System.out.println("Name: " + getAsStringSafe(json, "name"));
            System.out.println("Public Repos: " + json.get("public_repos").getAsInt());
            System.out.println("Followers: " + json.get("followers").getAsInt());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String getAsStringSafe(JsonObject json, String memberName) {
        JsonElement elem = json.get(memberName);
        if (elem != null && !elem.isJsonNull()) {
            return elem.getAsString();
        } else {
            return "N/A";
        }
    }
}
