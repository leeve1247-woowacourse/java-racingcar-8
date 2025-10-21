package racingcar;

import racingcar.config.RacingGameConfig;
import racingcar.model.RaceRecord;
import racingcar.model.UserInput;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        UserInput userInput = consoleView.getUserInput();
        RacingGameConfig racingGameConfig = new RacingGameConfig(userInput);
        CarRace carRace = new CarRace(racingGameConfig);
        RaceRecord raceRecord = carRace.play(consoleView);
        consoleView.printResult(raceRecord);
    }
}
