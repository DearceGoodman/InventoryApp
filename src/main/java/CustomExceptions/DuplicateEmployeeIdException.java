package CustomExceptions;

public class DuplicateEmployeeIdException extends RuntimeException{

    public DuplicateEmployeeIdException(String message){
        super(message);
    }
}
