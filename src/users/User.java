package users;

import java.time.LocalDate;

import tools.CurrentDate;

public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDate creationDate;

    public User(String email, String firstName, String lastName, String password){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.creationDate = CurrentDate.getCurrentDate();
    }


    public String getNames(){
        return this.firstName + " " + this.lastName;
    }


    public String getEmail(){
        return this.email;
    }

    public String getFirstName(){
        return this.firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }





    @Override
    public String toString() {
        return "User: \n " + "email: " + this.email + " \n first name: " + this.firstName + "\n last name: " + this.lastName + " \n account created: " + this.creationDate;
    }
}
