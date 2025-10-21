package racingcar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingGameConfig {
    private static final int MaxCarNameLength = 5;

    private Map<Long, Car> cars = new LinkedHashMap<>();
    private int tryCount = 0;

    public RacingGameConfig(UserInput userInput) {
        this.cars = parseCarNames(userInput.carNames());
        this.tryCount = Integer.parseInt(userInput.tryCount());
    }

    public Map<Long, Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    private Map<Long, Car> parseCarNames(String userInputCarNames) {
        List<String> carNameList = Arrays.stream(userInputCarNames.split(",")).map(String::strip).toList();
        long id = 1L;
        for (String name : carNameList) {
            validate(name);
            cars.put(id++, new Car(name));
        }
        return cars;
    }

    private void validate(String name) {
        validateDuplicate(name);
        validateTooLongCarName(name);
        validateBlankName(name);
    }

    private void validateBlankName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be empty.");
        }
    }

    private void validateTooLongCarName(String name) {
        if (name.length() > RacingGameConfig.MaxCarNameLength) {
            throw new IllegalArgumentException("Car name must be 5 characters or less.");
        }
    }


    private void validateDuplicate(String name) {
        if (cars.values().stream().anyMatch(car -> car.getName().equals(name))) {
            throw new IllegalArgumentException("Duplicate car names are not allowed.");
        }
    }
}
