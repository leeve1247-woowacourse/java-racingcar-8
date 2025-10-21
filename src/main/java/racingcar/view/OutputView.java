package racingcar.view;

import java.util.List;
import racingcar.Car;
import racingcar.Round;

public class OutputView {

    public void printResult(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void print(List<Round> rounds) {
        System.out.println("실행 결과");
        for (Round round : rounds) {
            printRound(round.getCars());
            System.out.println();
        }
    }

    private void printRound(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        });
    }


}
