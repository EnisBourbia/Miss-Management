package exceptions;

public class PasswordException extends RuntimeException{
    public PasswordException(){
        super("Password cannot be empty.");
    }
}
