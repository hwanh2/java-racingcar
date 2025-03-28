package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parseCarName(String input) {
        return Arrays.stream(input.replaceAll(" ","").split(",")).toList();
    }
    public static int parseTrail(String input){
        return Integer.parseInt(input.trim());
    }
}
