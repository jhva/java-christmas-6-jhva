package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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

    @Test
    void 날짜_다시_입력_받는_여지_테스트() {
        assertSimpleTest(() -> {
            runException("27");
            assertThat(output()).contains("26일 이후 부터는 크리스마스 혜택을 받을 수 없습니다. 진행하시겠습니까?\n1.계속 2.돌아가기");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
