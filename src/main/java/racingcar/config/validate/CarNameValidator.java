package racingcar.config.validate;

import java.util.List;
import racingcar.model.Car;

public record CarNameValidator(List<Car> cars) {
    private static final int MaxCarNameLength = 5;

    public void check(String carName) {
        checkIfDuplicated(carName);
        checkIfTooLong(carName);
        checkIfBlank(carName);
    }

    private void checkIfBlank(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("Car carName cannot be empty.");
        }
    }

    private void checkIfTooLong(String carName) {
        if (carName.length() > MaxCarNameLength) {
            throw new IllegalArgumentException("Car name must be 5 characters or less.");
        }
    }


    private void checkIfDuplicated(String carName) {
        if (cars.stream().anyMatch(car -> car.getName().equals(carName))) {
            throw new IllegalArgumentException("Duplicate car names are not allowed.");
        }
    }
}
