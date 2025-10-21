package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.config.RacingGameConfig;
import racingcar.view.ConsoleView;

public class CarRace {
    private final RacingGameConfig racingGameConfig;
    private final List<Round> rounds = new ArrayList<>();

    public CarRace(RacingGameConfig racingGameConfig) {
        this.racingGameConfig = racingGameConfig;
    }

    public RaceRecord play(ConsoleView consoleView) {
        List<Car> cars = racingGameConfig.getCars();
        int round = 1;

        while (round <= racingGameConfig.getTryCount()) {
            cars.forEach(car -> {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    car.moveForward();
                }
            });
            rounds.add(new Round(cars));
            round++;
        }

        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).toList();

        return new RaceRecord(winners, rounds);
    }
}
