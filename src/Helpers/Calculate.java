package Helpers;

import java.util.HashMap;

public class Calculate {
    public static Integer Go(HashMap<String, Object> collection){
        Integer first = Integer.parseInt(collection.get("first").toString());
        Integer second = Integer.parseInt(collection.get("second").toString());
        String znak = (String)collection.get("znak");
        return switch (znak) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> 0;
        };
    }
}
