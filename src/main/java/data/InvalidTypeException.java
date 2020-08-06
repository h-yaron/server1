package data;

public class InvalidTypeException extends RuntimeException {
    public InvalidTypeException(String type) {
        super("Could not find type: " + type);
    }
}


