package projects;

import tools.RandomID;
import users.User;

public class Task {

    private User userAssigned;
    private String taskTitle;
    private String taskDescription;
    private String projectID;
    private String taskProgress;
    private String taskID;

    public Task(User user, String projectID, String taskTitle, String taskDescription){
        this.userAssigned  = user;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.projectID = projectID;
        this.taskProgress = "Not started";
        this.taskID = RandomID.getRandomID();
    }

    public String getTaskID(){
        return this.taskID;
    }

    public void setUserAssigned(User user){
        this.userAssigned = user;
    }

    public void setTaskNotStarted(){
        this.taskProgress = "Not started";
    }

    public String getTaskProgress(){
        return this.taskProgress;
    }


    public void setTaskInProgress(){
        this.taskProgress = "In progress";
    }

    public void setTaskDone(){
        this.taskProgress = "Done";
    }


    public User getUserAssigned() {
        return this.userAssigned;
    }

    public String getProjectID() {
        return this.projectID;
    }


    public String getTaskName() {
        return this.taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public String toString() {
        return "Task: " +  "\n project id: " + this.getProjectID() +  "\n user assigned: " + this.getUserAssigned().getEmail() +  "\n task name: " + this.taskTitle + "\n task description: " + getTaskDescription() + "\n task progress: " + this.taskProgress;
    }



}
