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
            runException("0", "45");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
                    .isInstanceOf(UserInputException.class);
        });
    }

    @Test
    void 메뉴_테스트() {
        assertThatThrownBy(() -> {
            runException("12", "ㅁㄴㅇㄹ-1,ㅁㄴㅇ3");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
                    .isInstanceOf(UserInputException.class);
        });
    }

    @Test
    void 메뉴_중복_테스트() {
        assertThatThrownBy(() -> {
            runException("23", "티본스테이크-1,티본스테이크-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
                    .isInstanceOf(UserInputException.class);
        });
    }

    @Test
    void 음료_입력_테스트() {
        assertThatThrownBy(() -> {
            runException("23", "제로콜라-3");
            assertThat(output()).contains("[ERROR] 음료만 있는 주문은 처리할 수 없습니다. 다시 입력 해주세요.")
                    .isInstanceOf(UserInputException.class);
        });
    }

    @Test
    void 메뉴_개수_테스트() {
        assertThatThrownBy(() -> {
            runException("23", "티본스테이크-19,타파스-2");
            assertThat(output()).contains("[ERROR] 메뉴의 총 개수 20개를 초과하였습니다. 다시 입력해 주세요")
                    .isInstanceOf(UserInputException.class);
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
