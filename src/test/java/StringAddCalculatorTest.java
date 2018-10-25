import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringAddCalculatorTest {
    private StringAddCalculator cal;

    @Before
    public void setup() {
        cal = new StringAddCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, cal.calculateStringArray(null));
    }

    @Test
    public void add_숫자하나() throws Exception {
        String inputString = "1";
        String arrayString[] = cal.splitString(inputString, cal.foundCustomSplitor(inputString));
        assertEquals(1, cal.calculateStringArray(arrayString));
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        String inputString = "1,2";
        String arrayString[] = cal.splitString(inputString, cal.foundCustomSplitor(inputString));
        assertEquals(3, cal.calculateStringArray(arrayString));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        String inputString = "1,2:3";
        String arrayString[] = cal.splitString(inputString, cal.foundCustomSplitor(inputString));
        assertEquals(6, cal.calculateStringArray(arrayString));
    }

    @Test
    public void add_custom_구분자() throws Exception {
        String inputString = "//;\n1;2;3";
        String arrayString[] = cal.splitString(inputString, cal.foundCustomSplitor(inputString));
        assertEquals(6, cal.calculateStringArray(arrayString));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative() throws Exception {
        cal.foundNegative("-1,2,3");

    }
}