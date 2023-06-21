package org.example.task2;

import java.util.List;

import static org.example.task2.TaskApp.getOpenTasksForUser;
import static org.example.task2.TaskApp.printAllCommentsLastPost;

public class Main {
    public static void main(String[] args) {
        int userId = 1;
        List<UserEntity> openTasks = getOpenTasksForUser(userId);

        int postId = openTasks.size();
        List<PostEntity> postEntities = printAllCommentsLastPost(openTasks.size());

        String fileName = "user-" + userId + "-post-" + postId + "-comments.json";
        String result = "";

//        if (openTasks != null) {
//            System.out.println("Open tasks for User ID " + userId + ":");
//            System.out.println("openTasks.size() = " + openTasks.size());
//            for (UserEntity task : openTasks) {
//                System.out.println(task.getId() + ": " + task.getTitle());
//            }
//        } else {
//            System.out.println("Failed to retrieve open tasks for User ID " + userId);
//        }



        if (openTasks != null) {
            System.out.println("Open tasks for User ID " + userId + ":");
            for (UserEntity task : openTasks) {
                result += task.getTitle() + "\n";
                System.out.println(task.getId() + ": " + task.getTitle());
            }
        } else {
            System.out.println("Failed to retrieve open tasks for User ID " + userId);
        }

        System.out.println("result = " + result);

//    private static void saveCommentsToFile(String commentsJson, String fileName) {
//        try {
//            FileWriter fileWriter = new FileWriter(fileName);
//            fileWriter.write(commentsJson);
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
