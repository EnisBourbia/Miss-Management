package users;

import java.util.ArrayList;

public class UserLibrary {
    private ArrayList<User> userList = new ArrayList<>();

    public void addUser(User newUser){
        userList.add(newUser);
    }

    public void registerUser(String email, String firstName, String lastName, String password){
        User newUser = new User( email,  firstName,  lastName, password);
        userList.add(newUser);
    }

    public User getUser(String email){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getEmail().equals(email)){
                return userList.get(i);
            }
        }
        return null;
    }

    public  void listUsers(){
        for(int i = 0; i < userList.size(); i++){
            System.out.println(userList.get(i).toString());
        }
    }


    public boolean isEmailRegistered(String email){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public boolean isRegistered(String email, String password){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getEmail().equals(email) && userList.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public String exportUserData() {
        if (userList.size() == 0) {
            return "There are no users.";
        } else {
            StringBuilder builder = new StringBuilder();
            for (User user : userList) {
                String email = user.getEmail();
                String firstName = user.getFirstName();
                String lastName = user.getLastName();
                String password = user.getPassword();

                builder.append("User;" + firstName + ";" + lastName + ";" + email + ";" + password + ";");
                builder.append("\n");
            }
            return builder.toString();
        }
    }




}
