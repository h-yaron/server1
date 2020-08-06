package data;

import org.springframework.stereotype.Component;

@Component
public class StringMessageType extends MessageType<Integer> {

    public static final String TYPE_NAME = "String";

    public StringMessageType() {
        super(TYPE_NAME);
    }

    @Override
    public Integer getValue(String value) {
        return Integer.parseInt(getNumberValue(value));
    }

    private String getNumberValue(String value) {
        return value.substring(1, value.length() - 1);
    }

    @Override
    public double getDoubleValue(String value) {
        return getValue(value).doubleValue();
    }

    @Override
    public void verify(String value) {
        if (value.length() < 3 || !('"' == value.charAt(0)) || !('"' == value.charAt(value.length() - 1)) ) {
            throw  new InvalidValueException(TYPE_NAME, value);
        }
        try {
            getValue(value);
        } catch (NumberFormatException er) {
            throw  new InvalidValueException(TYPE_NAME , value);
        }
    }
}
