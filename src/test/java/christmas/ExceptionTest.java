package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.exception.UserInputException;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends NsTest {


    @Test
    void 날짜_재입력() {
        assertThatThrownBy(() -> {
            runException("0,45");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
                    .isInstanceOf(UserInputException.class);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
