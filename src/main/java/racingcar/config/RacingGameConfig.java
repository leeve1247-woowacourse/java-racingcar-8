package racingcar.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.config.validate.RacingGameConfigValidator;
import racingcar.model.Car;
import racingcar.model.UserInput;

public class RacingGameConfig {

    private List<Car> cars = new ArrayList<>();
    RacingGameConfigValidator racingGameConfigValidator = new RacingGameConfigValidator(cars);
    private int tryCount = 0;

    public RacingGameConfig(UserInput userInput) {
        this.cars = parseCarNames(userInput.carNames());
        this.tryCount = parseTryCount(userInput);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    private List<Car> parseCarNames(String userInputCarNames) {
        List<String> carNameList = Arrays.stream(userInputCarNames.split(",")).map(String::strip).toList();
        for (String carName : carNameList) {
            racingGameConfigValidator.check(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    private int parseTryCount(UserInput userInput) {
        int tryCount = Integer.parseInt(userInput.tryCount());
        racingGameConfigValidator.check(tryCount);
        return tryCount;
    }
}
