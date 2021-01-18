package users;

import java.util.ArrayList;

public class SysAdminLibrary extends UserLibrary {
    public void addSysAdmin(String email, String firstName, String lastName, String password){
        SysAdmin sysAdmin = new SysAdmin(email, firstName,lastName, password);
        addUser(sysAdmin);
    }

}
