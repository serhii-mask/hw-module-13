package org.example.task2;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TaskApp {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final Gson gson = new Gson();
    private static final HttpClient httpClient = HttpClients.createDefault();

    public static List<UserEntity> getOpenTasksForUser(int userId) {
        String url = BASE_URL + "/users/" + userId + "/posts";

        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                String responseBody = EntityUtils.toString(response.getEntity());
                UserEntity[] tasks = gson.fromJson(responseBody, UserEntity[].class);
                return Arrays.asList(tasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<PostEntity> printAllCommentsLastPost(int postId) {

        String url = BASE_URL + "/posts/" + postId + "/comments";

        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                String responseBody = EntityUtils.toString(response.getEntity());
                PostEntity[] tasks = gson.fromJson(responseBody, PostEntity[].class);
                return Arrays.asList(tasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void saveCommentsToFile(String commentsJson, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(commentsJson);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
