package racingcar.model;

import java.util.List;

public record Round(List<Car> cars) {
    public Round(List<Car> cars) {
        this.cars = cars.stream().map(this::deepCopy).toList();
    }

    private Car deepCopy(Car car) {
        return new Car(car.getName(), car.getPosition());
    }
}
