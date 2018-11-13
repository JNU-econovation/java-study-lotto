import model.LottoNo;
import model.WinningLotto;
import org.junit.Test;
import utils.ManualTicketGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    WinningLotto winningLotto;

    @Test
    public void WinningLottoTest() {
        winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        List<LottoNo> ticket = ManualTicketGenerator.issue("1, 2, 3, 4, 5, 6");
        assertThat(winningLotto.getWinningTicket()).isEqualTo(ticket);
    }
}
