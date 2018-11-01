import model.Lotto;
import model.LottoNo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;

    @Test
    public void Lotto_자동티켓발급() {
        lotto = new Lotto();
    }

    @Test
    public void Lotto_수동티켓발급() {
        lotto = new Lotto("1, 2, 3, 4, 5, 6");
        List<LottoNo> ticket1 = lotto.getTicket();
        List<LottoNo> ticket2 = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            ticket2.add(new LottoNo(i));
        }

        assertThat(ticket1).isEqualTo(ticket2);
    }
}
