package racingcar.view;

import java.util.List;

public class OutputView {

    public void printResult(List<String> winners) {
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }
}
