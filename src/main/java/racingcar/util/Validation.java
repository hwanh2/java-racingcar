package racingcar.util;

import java.util.List;

public class Validation {
    private static final int CAR_NAME_MIN = 1;
    private static final int CAR_NAME_MAX = 5;
    private static final String SPACE = " ";

    public static void checkCarNamesInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input); // 빈 입력인지 확인
        List<String> carNameList = Parser.parseCarName(input);
        checkCarNameListDuplicationAndThrowException(carNameList); // 중복된 이름이 있는지 확인
        checkEachCarNameLengthAndSpaceThrowException(carNameList); // 자동차의 글자 수 확인
    }

    private static void checkEmptyAndThrowException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private static void checkCarNameListDuplicationAndThrowException(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            for (int j = i + 1; j < carNameList.size(); j++) {
                checkEqualsAndThrowException(carNameList.get(i), carNameList.get(j));
            }
        }
    }

    private static void checkEqualsAndThrowException(String carName1, String carName2) {
        if (carName1.equals(carName2)) {
            throw new IllegalArgumentException("[ERROR] 같은 이름을 가진 자동차가 있습니다.");
        }
    }

    private static void checkEachCarNameLengthAndSpaceThrowException(List<String> carNameList) {
        for (String carName : carNameList) {
            checkLengthAndThrowException(carName); // 자동차 이름의 길이 확인
            checkSpaceAndThrowException(carName); // 자동차 이름에 공백이 있나 확인
        }
    }

    private static void checkLengthAndThrowException(String carName) {
        if (CAR_NAME_MAX < carName.length()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + CAR_NAME_MAX + "글자 이하여야 합니다.");
        }
        if (CAR_NAME_MIN> carName.length()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + CAR_NAME_MIN + "글자 이상이어야 합니다.");
        }
    }

    private static void checkSpaceAndThrowException(String carName) {
        if (carName.contains(SPACE)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름안에는 공백이 있어서는 안됩니다.");
        }
    }


}
