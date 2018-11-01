import dto.LottoDTO;
import model.LottoGame;
import model.Result;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private Result result;
    private LottoDTO lottoDTO;
    private int count;

    @Before
    public void setUp() throws Exception {
        count = 5;
        lottoDTO = new LottoGame(count).toLottoDTO();
        result = new Result("4, 5, 6, 7, 8, 9", lottoDTO);
    }

    @Test
    public void getMatchCount_로또하나_받아서_몇개일치하는지_반환() {
        List<Integer> lottery = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        //assertThat(result.getMatchCount(lottery)).isEqualTo(3);
    }

    @Test
    public void getStatistics_size가_4인_리스트반환() {
        int size = result.getStatistics().size();
        assertThat(size).isEqualTo(4);
    }

    @Test
    public void getProfitTest() {
        result.getStatistics();
        assertThat(result.getProfit()).isNotNull();
    }

    @Test
    public void toListTest() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result.toList("1, 2, 3, 4, 5, 6")).isEqualTo(list);
    }
}
