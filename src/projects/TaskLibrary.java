package projects;

import users.User;

import java.util.ArrayList;

public class TaskLibrary {

    private ArrayList<Task> taskList = new ArrayList<>();

    public void addTask(Task task){
        taskList.add(task);
    }
    public void registerTask(User user, String projectID, String taskTitle, String taskDescription, String taskProgress){
        Task task = new Task( user,  projectID,  taskTitle, taskDescription);
        if(taskProgress.equalsIgnoreCase("In Progress")){
            task.setTaskInProgress();
        } else if(taskProgress.equalsIgnoreCase("Done")){
            task.setTaskDone();
        } else{
            task.setTaskNotStarted();
        }
        taskList.add(task);
    }



    public void removeTask(Task task){
        taskList.remove(task);
    }


    public void listAllTasks(){
        for(int i = 0; i < taskList.size(); i++){
            System.out.println(taskList.get(i).toString());
        }
    }


    public String exportTaskData(ProjectLibrary projectLibrary){
        if (taskList.size() == 0) {
            return "";
        } else{
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < taskList.size(); i++){
                Task task = taskList.get(i);
                builder.append("Task;" + task.getUserAssigned().getEmail() + ";" + projectLibrary.getProjectNumFromID(task.getProjectID()) + ";" + task.getTaskName() + ";" + task.getTaskDescription() + ";" + task.getTaskProgress() + ";" );
                builder.append("\n");
            }
            return builder.toString();
        }
    }


    public ArrayList<Task> getAllProjectTasks(String projectID){
        ArrayList<Task> projectTasks = new ArrayList<>();

        for (int i = 0; i < taskList.size(); i++){
            if(taskList.get(i).getProjectID().equals(projectID)){
                projectTasks.add(taskList.get(i));
            }
        }
        return projectTasks;
    }


    public Task getTaskFromID(String ID) {
        for(Task task : taskList){
            if(task.getTaskID().equals(ID)){
                return task;
            }
        }
        return null;
    }


    public boolean doesTaskNameExistInProject(String projectID,String taskName){
        for(int i = 0; i < taskList.size(); i++){
            Task task = taskList.get(i);
            if(task.getTaskName().equals(taskName) && task.getProjectID().equals(projectID)){
                return true;
            }
        }
        return false;
    }


    public ArrayList<Task> getAllUserTasks(User user, String projectID){
        ArrayList<Task> userTasks = new ArrayList<>();
        for (int i = 0; i < taskList.size(); i++){
            if(taskList.get(i).getUserAssigned().getEmail().equals(user.getEmail()) && taskList.get(i).getProjectID().equals(projectID)){
                userTasks.add(taskList.get(i));
            }
        }
        return userTasks;
    }



}
