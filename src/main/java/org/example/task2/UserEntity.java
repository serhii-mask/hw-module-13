package org.example.task2;

public class UserEntity {
    private int userId;
    private int id;
    private String title;
    private String body;

    /**
     * Gets the ID of the user associated with the task.
     *
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user associated with the task.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the ID of the task.
     *
     * @return The task ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the task.
     *
     * @param id The task ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the title of the task.
     *
     * @return The task title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the task.
     *
     * @param title The task title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body=" + body +
                '}';
    }
}
