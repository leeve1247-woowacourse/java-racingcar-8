package racingcar.config.validate;

import java.util.List;
import racingcar.model.Car;

public class RacingGameConfigValidator {
    private final CarNameValidator carNamesValidator;
    private final TryCountValidator tryCountValidator;

    public RacingGameConfigValidator(List<Car> cars) {
        this.carNamesValidator = new CarNameValidator(cars);
        this.tryCountValidator = new TryCountValidator();
    }

    public void check(int tryCount) {
        tryCountValidator.check(tryCount);
    }

    public void check(String carName) {
        carNamesValidator.check(carName);
    }
}
