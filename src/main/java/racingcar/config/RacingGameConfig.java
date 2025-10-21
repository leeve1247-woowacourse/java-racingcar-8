package racingcar.config;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.Car;
import racingcar.UserInput;

public class RacingGameConfig {
    private Map<Long, Car> cars = new LinkedHashMap<>();
    private int tryCount = 0;
    CarNameValidator carNameValidator = new CarNameValidator(cars);

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
            carNameValidator.validate(name);
            cars.put(id++, new Car(name));
        }
        return cars;
    }
}
