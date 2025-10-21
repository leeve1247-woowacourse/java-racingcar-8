package racingcar.view;

import racingcar.model.RaceRecord;
import racingcar.model.UserInput;

public class ConsoleView {
    private final InputView inputView;
    private final OutputView outputView;

    public ConsoleView() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public UserInput getUserInput() {
        return inputView.readUserInput();
    }

    public void printResult(RaceRecord raceRecord) {
        outputView.print(raceRecord.rounds());
        outputView.printResult(raceRecord.winners());
    }
}
