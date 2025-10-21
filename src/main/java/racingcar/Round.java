package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private final List<Car> cars = new ArrayList<>();

    public Round(List<Car> cars) {
        cars.forEach(this::deepCopy);
    }

    private void deepCopy(Car car) {
        this.cars.add(new Car(car.getName(), car.getPosition()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
