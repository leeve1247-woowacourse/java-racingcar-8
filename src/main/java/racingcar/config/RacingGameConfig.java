package racingcar.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.UserInput;

public class RacingGameConfig {
    private List<Car> cars = new ArrayList<>();
    CarNameValidator carNameValidator = new CarNameValidator(cars);
    private int tryCount = 0;

    public RacingGameConfig(UserInput userInput) {
        this.cars = parseCarNames(userInput.carNames());
        this.tryCount = Integer.parseInt(userInput.tryCount());
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    private List<Car> parseCarNames(String userInputCarNames) {
        List<String> carNameList = Arrays.stream(userInputCarNames.split(",")).map(String::strip).toList();
        long id = 1L;
        for (String name : carNameList) {
            carNameValidator.validate(name);
            cars.add(new Car(name));
        }
        return cars;
    }
}
