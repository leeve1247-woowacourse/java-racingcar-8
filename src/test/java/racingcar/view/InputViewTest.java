package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.UserInput;

@SuppressWarnings("NonAsciiCharacters")
class InputViewTest extends NsTest {

    InputView inputView = new InputView();
    UserInput userInput = null;

    @Test
    void 정상입력() {
        assertSimpleTest(() -> {
            run("pobi,pobi2", "1");
            assertThat(userInput.carNames()).isEqualTo("pobi,pobi2");
            assertThat(userInput.tryCount()).isEqualTo("1");
        });
    }

    @Test
    void 공백입력() {
        assertSimpleTest(() -> {
            run("", "");
            assertThat(userInput.carNames()).isEqualTo("");
            assertThat(userInput.tryCount()).isEqualTo("");
        });
    }

    @Override
    protected void runMain() {
        userInput = inputView.readUserInput();
    }
}