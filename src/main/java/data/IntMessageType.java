package data;

import org.springframework.stereotype.Component;

@Component
public class IntMessageType extends MessageType<Integer> {

    public static final String TYPE_NAME = "Int";

    public IntMessageType() {
        super(TYPE_NAME);
    }

    @Override
    public Integer getValue(String value) {
        return Integer.parseInt(value);
    }

    @Override
    public double getDoubleValue(String value) {
        return getValue(value).doubleValue();
    }

    @Override
    public void verify(String value) {
        try {
            getValue(value);
        } catch (NumberFormatException er) {
            throw  new InvalidValueException(TYPE_NAME, value);
        }
    }
}
