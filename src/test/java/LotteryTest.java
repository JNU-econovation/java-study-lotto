import model.Lottery;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    private Lottery lottery;

    @Before
    public void setUp() throws Exception {
        lottery = new Lottery();
    }

    @Test
    public void createBalls_1부터_45까지_로또공_반환() {
        int size = lottery.createBalls().size();
        assertThat(size).isEqualTo(45);
    }

    @Test
    public void issue_로또발급() {
        int size = lottery.issue().size();
        assertThat(size).isEqualTo(6);
    }
}
