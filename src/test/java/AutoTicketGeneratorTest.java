import model.LottoNo;
import org.junit.Test;
import utils.AutoTicketGenerator;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoTicketGeneratorTest {

    @Test
    public void createBalls_1부터_45까지_로또공_생성() {
        List<LottoNo> balls = AutoTicketGenerator.createBalls();
        for (LottoNo ball : balls) {
            assertThat(ball.getNumber()).isBetween(1, 45);
        }
        assertThat(balls.size()).isEqualTo(45);
    }

    @Test
    public void issue_로또번호가_중복되지않게_티켓발급() {
        List<LottoNo> ticket = AutoTicketGenerator.issue();
        Set<Integer> set = new HashSet<>();

        for (LottoNo lottoNo : ticket) {
            set.add(lottoNo.getNumber());
        }
        assertThat(set.size()).isEqualTo(6);
    }
}
