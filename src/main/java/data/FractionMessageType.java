package data;

import org.springframework.stereotype.Component;

@Component
public class FractionMessageType extends MessageType<Double> {

    public static final String TYPE_NAME = "Fraction";

    public FractionMessageType() {
        super(TYPE_NAME);
    }

    @Override
    public Double getValue(String value) {
        value = getNumberValue(value);
        int divideLoc = value.indexOf("/");
        if (divideLoc < 1 || divideLoc == value.length()) {
            throw new NumberFormatException("Require x/y");
        }
        return Double.parseDouble(value.substring(0,divideLoc)) /
                Double.parseDouble(value.substring(divideLoc+1));
    }

    private String getNumberValue(String value) {
        return value.substring(1, value.length() - 1);
    }

    @Override
    public double getDoubleValue(String value) {
        return getValue(value);
    }

    @Override
    public void verify(String value) {
        if (value.length() < 5 || !('"' == value.charAt(0)) || !('"' == value.charAt(value.length() - 1)) ) {
            throw  new InvalidValueException(TYPE_NAME, value);
        }
        try {
            getValue(value);
        } catch (NumberFormatException er) {
            throw  new InvalidValueException(TYPE_NAME, value);
        }
    }
}
