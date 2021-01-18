package projects;

import users.User;

import java.util.ArrayList;

public class ProjectLibrary {
    private ArrayList<Project> projectList = new ArrayList<>();

    public void addProject(Project newProject){
        projectList.add(newProject);
    }

    public void registerProject(String projectName, String projectDescription){
        Project newProject = new Project(projectName,projectDescription);
        projectList.add(newProject);
    }

    public String exportProjectData(){
        if (projectList.size() == 0) {
            return "";
        } else{
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < projectList.size(); i++){
                Project project = projectList.get(i);
                builder.append("Project;" + ";" + project.getProjectName() + ";" + project.getProjectDescription() + ";");
                builder.append("\n");
            }
            return builder.toString();
        }
    }


    public void listAllProjects(){
        for(int i = 0; i < projectList.size(); i++){
            System.out.println(projectList.get(i).toString());
        }
    }

    public boolean checkIfProjectExists(String ID){
        for (int i = 0; i < projectList.size(); i++){
            if(projectList.get(i).getProjectID().equals(ID)){
                return true;
            }
        }
        return false;
    }

    public Project getProject(String ID){
        for (int i = 0; i < projectList.size(); i++){
            if(projectList.get(i).getProjectID().equals(ID)){
                return projectList.get(i);
            }
        }
        return null;
    }

    public Project getNumProject(int num){
      return projectList.get(num - 1);
    }

    public int getProjectNumFromID(String ID){
        for (int i = 0; i < projectList.size(); i++) {
            if(projectList.get(i).getProjectID().equals(ID)){
                return i + 1;
            }
        }
        return - 1;
    }



    public ArrayList<Project> getAllActiveProjects(ArrayList<String> projectIDS){
        ArrayList<Project> userActiveProjects = new ArrayList<>();
        for (int i = 0; i < projectList.size(); i++){
            if(projectList.get(i).getStatus().equalsIgnoreCase("In Progress")){
                for(int j = 0; j < projectIDS.size(); j++){
                    if(projectList.get(i).getProjectID().equals(projectIDS.get(j))){
                        userActiveProjects.add(projectList.get(i));
                    }
                }
            }
        }
        return userActiveProjects;
    }

    public ArrayList<Project> getAllClosedProjects(ArrayList<String> projectIDS){
        ArrayList<Project> userClosedProjects = new ArrayList<>();
        for (int i = 0; i < projectList.size(); i++){
            if(projectList.get(i).getStatus().equalsIgnoreCase("Closed")){
                for(int j = 0; j < projectIDS.size(); j++){
                    if(projectList.get(i).getProjectID().equals(projectIDS.get(j))){
                        userClosedProjects.add(projectList.get(i));
                    }
                }
            }
        }
        return userClosedProjects;
    }

    public ArrayList<Project> getProjects(ArrayList<String> projectIDS){
        ArrayList<Project> userProjects = new ArrayList<>();
        for (int i = 0; i < projectList.size(); i++){
            for(int j = 0; j < projectIDS.size(); j++){
                if(projectList.get(i).getProjectID().equals(projectIDS.get(j))){
                    userProjects.add(projectList.get(i));
                }
            }
        }
        return userProjects;
    }

}
