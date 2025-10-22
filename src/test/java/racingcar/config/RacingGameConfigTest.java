package racingcar.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.UserInput;

@SuppressWarnings("NonAsciiCharacters")
class RacingGameConfigTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void 공백을_포함한_차() {
        UserInput userInput = new UserInput("AA +1", "1");
        RacingGameConfig racingGameConfig = new RacingGameConfig(userInput);
        assertEquals(1, racingGameConfig.getCars().size());
    }

    @Test
    void 빈_차_이름() {
        UserInput userInput = new UserInput("", "1");
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGameConfig(userInput);
        });
    }

    @Test
    void 공백_차_와_일반_차() {
        UserInput userInput = new UserInput(",aaron", "1");
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGameConfig(userInput);
        });
    }

    @Test
    void 중복된_차_이름() {
        UserInput userInput = new UserInput("AA,AA", "1");
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGameConfig(userInput);
        });
    }

    @Test
    void 음수_시행_횟수() {
        UserInput userInput = new UserInput("AA,BB", "-1");
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGameConfig(userInput);
        });
    }

    @Test
    void 다섯자_초과_차_이름() {
        UserInput userInput = new UserInput("AAAAAA", "1");
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGameConfig(userInput);
        });
    }

    @Test
    void 다섯자_초과_차_이름_2() {
        UserInput userInput = new UserInput("pobi,javaji", "1");
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGameConfig(userInput);
        });
    }
}