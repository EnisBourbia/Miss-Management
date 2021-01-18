package projects;

import users.User;

public class Salary {

    private String email;
    private String firstName;
    private String lastName;

    private double salary;
    private String projectID;
    private User user;
    private int hoursLogged;
    private double totalCosts;


    public Salary(User user, double salary,int hoursLogged, String projectID) {
        this.user = user;
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.salary = salary;
        this.projectID = projectID;
        this.hoursLogged = hoursLogged;
        setTotalCosts();
    }

    public void addHoursLogged(Integer hours){
        this.hoursLogged = hoursLogged + hours;
        setTotalCosts();
    }

    public void setTotalCosts(){
        this.totalCosts = hoursLogged * salary;
    }

    public String getProjectID() {
        return this.projectID;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getHoursLogged() {
        return this.hoursLogged;
    }

    public double getTotalCosts() {
        return this.totalCosts;
    }



    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User Salary:" +
                " first name='" + firstName + '\'' +
                " last name='" + lastName + '\'' +
                " email='" + email + '\'' +
                ", salary=$" + salary + " per hour" +
 +                '}';
    }
}
