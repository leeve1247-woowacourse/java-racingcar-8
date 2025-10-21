package racingcar.view;

import java.util.List;
import racingcar.UserInput;

public class ConsoleView {
    private final InputView inputView;
    private final OutputView outputView;

    public ConsoleView(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public UserInput getUserInput() {
        return new UserInput();
    }

    public void printResult(List<String> winners) {
    }
}
