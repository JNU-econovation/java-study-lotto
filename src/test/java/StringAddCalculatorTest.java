import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class StringAddCalculatorTest {
    private StringAddCalculator cal;

    @Before
    public void setup() {
        cal = new StringAddCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    public void add_숫자하나() throws Exception {
        assertEquals(12, cal.add("12"));
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    public void add_custom_구분자() throws Exception {
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative() throws Exception {
        cal.add("-1,2,3");
    }

    @Test(expected = RuntimeException.class)
    public void add_숫자_이외의_값() throws Exception {
        cal.add("ㅎㅎ");
    }

    @Test
    public void getTokens_쉼표_또는_콜론_구분자() {
        String text = "1,2:3";
        String[] tokens = {"1", "2", "3"};
        assertThat(cal.getTokens(text)).isEqualTo(tokens);
    }

    @Test
    public void getToekns_custom_구분자() {
        String text = "//;\n1;2;3";
        String[] tokens = {"1", "2", "3"};
        assertThat(cal.getTokens(text)).isEqualTo(tokens);
    }

    @Test
    public void isEmptyOrNullTest() {
        assertThat(cal.isEmptyOrNull("")).isTrue();
        assertThat(cal.isEmptyOrNull(null)).isTrue();
        assertThat(cal.isEmptyOrNull("1")).isFalse();
    }
    @Test(expected = RuntimeException.class)
    public void check_negative() throws Exception {
        cal.check("-1");
    }

    @Test(expected = RuntimeException.class)
    public void check_숫자_이외의_값() throws Exception {
        cal.check("ㅎㅎ");
    }

    @Test
    public void check_숫자() {
        cal.check("123");
    }
}