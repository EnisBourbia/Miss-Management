package projects;

import users.User;

import java.util.ArrayList;
import java.util.Collections;

public class NotificationLibrary {
    private ArrayList<Notification> notificationList = new ArrayList<>();


    public void sendNewUserNotification(ArrayList<User> receivers, User newUser, Project project){
        String title = project.getProjectName() + " - New User";
        String text = "A new team member has been added to " + project.getProjectName() + "! Please, welcome " + newUser.getNames() + "!";
        Notification newNotification = new Notification(receivers, title, text);
        notificationList.add(newNotification);
    }

    public void sendNewTaskNotification(ArrayList<User> receivers, Task newTask, Project project){
        String title = project.getProjectName() + " - New Task";
        String text = "A new task " + newTask.getTaskName() + " has been created in " + project.getProjectName() + "!";
        Notification newNotification = new Notification(receivers, title, text);
        notificationList.add(newNotification);
    }

    public void sendMeetingNotification(ArrayList<User> receivers, Project project){
        String title = project.getProjectName() + " - New Meeting";
        String text = "New Team Meeting has been scheduled for " + project.getProjectName() + ". Check your e-mail for more information.";
        Notification newNotification = new Notification(receivers, title, text);
        notificationList.add(newNotification);
    }

    public void sendNewProgressNotification(ArrayList<User> receivers, Task task, Project project){
        String title = project.getProjectName() + " - Task Progress Changed";
        String text = "Task " + task.getTaskName() + " in " + project.getProjectName() + " has been moved to " + task.getTaskProgress() + "!";
        Notification newNotification = new Notification(receivers, title, text);
        notificationList.add(newNotification);
    }

    public void sendTaskAssignedNotification(User receiver, Task task, Project project){
        String title = project.getProjectName() + " - New Task Assigned";
        String text = "You have been assigned a new task (" + task.getTaskName() + " ) in " + project.getProjectName() + "!";
        Notification newNotification = new Notification(receiver, title, text);
        notificationList.add(newNotification);
    }

    public void sendProjectAddedNotification(User receiver,Project project,Role role){
        String title = "Added To New Project";
        String text = "You have been added to a new project ( " + project.getProjectName() + " ) as a " + role.getRole() + "!";
        Notification newNotification = new Notification(receiver, title, text);
        notificationList.add(newNotification);
    }

    public void deleteNotification(Notification notification, User user) {
        if(notification.deleteReceiver(user) == null){
            notificationList.remove(notification);
        }
    }


    public ArrayList<Notification> getAllNotificationsOfUser(User user){
        ArrayList<Notification> notificationsOfUser = new ArrayList<>();
        for (Notification notification : notificationList) {
            if (notification.getIndividualReceiver(user) == user | notification.getReceiver() == user) {
                notificationsOfUser.add(notification);
            }
        }

        //bubble sort
        //sorts the notifications of the user to display the most recent ones first
        for(int i=0; i<notificationsOfUser.size()-1; i++){
            for(int j=0; j<notificationsOfUser.size()-i-1; j++){
                if(!notificationsOfUser.get(j).isAfter(notificationsOfUser.get(j+1))){
                    Collections.swap(notificationsOfUser, j,j+1);
                }
            }
        }
        return notificationsOfUser;
    }

    public void listAllNotifications(){
        for (int i = 0; i < notificationList.size(); i++){
            System.out.println(notificationList.get(i).toString());
        }
    }



    public Notification getNotificationFromID(String notificationID) {
        for(Notification notification : notificationList){
            if(notification.getNotificationID().equals(notificationID)){
                return notification;
            }
        }
        return null;
    }
}
