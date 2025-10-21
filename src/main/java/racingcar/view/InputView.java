package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import racingcar.UserInput;

public class InputView {
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLineOrBlank();
    }

    public String readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return readLineOrBlank();
    }

    private static String readLineOrBlank() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e){
            return "";
        }
    }

    public UserInput readUserInput() {
        String carNames = readCarNames();
        String tryCount = readTryCount();
        return new UserInput(carNames, tryCount);
    }
}
