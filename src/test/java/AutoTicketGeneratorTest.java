import model.LottoNo;
import org.junit.Test;
import utils.AutoTicketGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoTicketGeneratorTest {

    @Test
    public void issue_각기다른_정수값_6개() {
        List<LottoNo> numbers = AutoTicketGenerator.issue();
        Set<Integer> set = new HashSet<>();

        for (LottoNo number : numbers) {
            set.add(number.getNumber());
        }

        assertThat(set.size()).isEqualTo(6);
    }
}
