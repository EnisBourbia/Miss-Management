package exceptions;

public class NameException extends RuntimeException{
    public NameException(){
        super("Name cannot be empty.");
    }
}

