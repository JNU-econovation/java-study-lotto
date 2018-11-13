import model.LottoNo;
import org.junit.Test;
import utils.ManualTicketGenerator;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualTicketGeneratorTest {

    @Test
    public void issue_입력한대로_발급() {
        List<LottoNo> list1 = ManualTicketGenerator.issue("1, 2, 3, 4, 5, 6");
        List<LottoNo> list2 = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list2.add(new LottoNo(i));
        }
        assertThat(list1).isEqualTo(list2);
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
