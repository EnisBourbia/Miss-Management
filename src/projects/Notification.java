package projects;

import tools.CurrentDate;
import tools.RandomID;
import users.User;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Notification {

    private String notificationID;
    private ArrayList<User> receivers;
    private User receiver;
    private String notificationTitle;
    private String notificationBody;
    private LocalDate date;

    //Constructor for notifications that have 2 or more receivers
    public Notification(ArrayList<User> receivers, String notificationTitle, String notificationBody){
        this.notificationID = RandomID.getRandomID();
        this.receivers = receivers;
        this.notificationTitle = notificationTitle;
        this.notificationBody = notificationBody;
        this.date = CurrentDate.getCurrentDate();
    }

    //Constructor for notifications that have a single receiver (e.g - Task Assigned)
    public Notification(User receiver, String notificationTitle, String notificationBody){
        this.notificationID = RandomID.getRandomID();
        this.receiver = receiver;
        this.notificationTitle = notificationTitle;
        this.notificationBody = notificationBody;
        this.date = CurrentDate.getCurrentDate();
    }


    public ArrayList<User> getReceivers(){
        return receivers;
    }

    public User deleteReceiver(User user){
        if(receivers != null){
            receivers.remove(user);
            return user;
        }
        return null;
    }

    public User getReceiver(){
        return receiver;
    }

    public User getIndividualReceiver(User user) {
        if (receivers != null) {
            for (User newUser : receivers) {
                if (newUser == user) {
                    return user;
                }
            }
        }
        return null;
    }
    public String getNotificationTitle(){
        return notificationTitle;
    }
    public String getNotificationBody(){
        return notificationBody;
    }
    public String getNotificationID(){
        return notificationID;
    }
    public boolean isAfter(Notification anotherNotification){
        return date.isAfter(anotherNotification.date);
    }
}
