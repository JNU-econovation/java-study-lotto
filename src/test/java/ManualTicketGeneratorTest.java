import model.LottoNo;
import org.junit.Test;
import utils.ManualTicketGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualTicketGeneratorTest {

    @Test
    public void issue_각기다른_정수값_6개() {
        List<LottoNo> numbers = ManualTicketGenerator.issue("1, 2, 3, 4, 5, 6");
        Set<Integer> set = new HashSet<>();

        for (LottoNo number : numbers) {
            set.add(number.getNumber());
        }

        assertThat(set.size()).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void issue_중복된수_입력시_예외발생() {
        ManualTicketGenerator.issue("1, 1, 2, 3, 4, 5");
    }

    @Test(expected = RuntimeException.class)
    public void issue_6개이하_입력시_예외발생() {
        ManualTicketGenerator.issue("1, 2, 3, 4, 5");
    }

    @Test(expected = RuntimeException.class)
    public void issue_6개이상_입력시_예외발생() {
        ManualTicketGenerator.issue("1, 2, 3, 4, 5, 6, 7");
    }

    @Test(expected = RuntimeException.class)
    public void issue_잘못입력시_예외발생() {
        ManualTicketGenerator.issue("부리또먹고싶다");
    }
}
