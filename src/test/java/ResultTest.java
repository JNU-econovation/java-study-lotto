import model.Result;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    Result result;

    @Before
    public void setUp() throws Exception {
        result = new Result(Arrays.asList(4, 5, 6, 7, 8, 9));
    }

    @Test
    public void getMatchCount_로또하나_받아서_몇개일치하는지_반환() {
        List<Integer> lottery = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result.getMatchCount(lottery)).isEqualTo(3);
    }
}
