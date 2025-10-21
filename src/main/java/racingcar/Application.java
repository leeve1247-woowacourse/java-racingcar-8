package racingcar;

import java.util.List;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        UserInput userInput = consoleView.getUserInput();
        RacingGameConfig racingGameConfig = new RacingGameConfig(userInput);
        CarRace carRace = new CarRace(racingGameConfig);
        List<String> winners = carRace.play(consoleView);
        consoleView.printResult(winners);
    }
}
