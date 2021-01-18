package projects;

import users.User;

import java.time.LocalDate;

public class Meeting {
    private String projectID;
    private User meetingCreator;
    private String location;
    private LocalDate meetingDate;

    public Meeting(String projectID, User meetingCreator, String location, LocalDate meetingDate){
        this.projectID = projectID;
        this.meetingCreator = meetingCreator;
        this.location = location;
        this.meetingDate = meetingDate;
    }

    public User getMeetingCreator(){
        return this.meetingCreator;
    }



    public String getProjectID(){
        return this.projectID;
    }

    public String getLocation(){
        return this.location;
    }

    public LocalDate getMeetingDate(){
        return this.meetingDate;
    }





    @Override
    public String toString() {
        return "Meeting: " +  "\n project id: " + this.projectID +  "\n meeting creator: " + this.meetingCreator.getEmail() + "\n location: " + this.location + "\n meeting date: " + meetingDate;
    }
}
