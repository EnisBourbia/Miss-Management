package projects;

import users.User;

public class Role {

    private User user;
    private String role;
    private String projectID;

    public Role(User user, String projectID){
        this.user  = user;
        this.projectID = projectID;
        this.role = "";
    }


    public User getUser(){
        return this.user;
    }

    public String getRole(){
        return this.role;
    }

    public String getProjectID(){
        return this.projectID;
    }

    public void setRoleProjectCreator(){
        this.role = "Project Creator";
    }



    public void setRoleScrumMaster(){
        this.role = "Scrum Master";
    }

    public void setRoleProductOwner(){
        this.role = "Product Owner";
    }

    public void setRoleDeveloper(){
        this.role = "Developer";
    }

    @Override
    public String toString() {
        return "Role: " + "\n email: " + user.getEmail() + "\n project id: " + this.getProjectID() + "\n role: " + this.role;
    }
}
