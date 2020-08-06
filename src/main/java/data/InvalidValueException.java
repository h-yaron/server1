package data;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException(String type, String value) {
        super("Could not parse: [" + value + "] for type: " + type);
    }
}


