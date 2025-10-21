package racingcar.config;

import java.util.Map;
import racingcar.Car;

public record CarNameValidator(Map<Long, Car> cars) {
    private static final int MaxCarNameLength = 5;

    public void validate(String name) {
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
        if (name.length() > MaxCarNameLength) {
            throw new IllegalArgumentException("Car name must be 5 characters or less.");
        }
    }


    private void validateDuplicate(String name) {
        if (cars.values().stream().anyMatch(car -> car.getName().equals(name))) {
            throw new IllegalArgumentException("Duplicate car names are not allowed.");
        }
    }
}
