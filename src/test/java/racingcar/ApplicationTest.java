package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final TestUtil testUtil = new TestUtil();


    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_2() {
        int valueOrder = 0;
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, testUtil.movementPattern(valueOrder)
        );
    }

    @Test
    void 기능_테스트_3(){
        int valueOrder = 2418273;
        assertRandomNumberInRangeTest(
                () -> {
                    run("aaaa,bbb,ccc,ddd,eee,ff,gg,h,aa", "22");
                    assertThat(output())
                            .contains("최종 우승자 : eee, h, aa")
                            .contains("eee : "+"-".repeat(22))
                            .contains("h : "+"-".repeat(22))
                            .contains("aa : "+"-".repeat(22))
                            .doesNotContain("eee : "+"-".repeat(23))
                            .doesNotContain("h : "+"-".repeat(23))
                            .doesNotContain("aa : "+"-".repeat(23))
                    ;
                },
                MOVING_FORWARD, testUtil.movementPattern(valueOrder)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
