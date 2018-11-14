import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class StringCalculatorTest {
    /*
    private StringCalculator cal;

    @Before
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    public void add_숫자하나() throws Exception {
        assertEquals(1, cal.add("1"));
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
*/
    @Test
    public void test(){
        String[] a = {"aaa", "bbb", "c"};

        Arrays.stream(a).forEach(s -> System.out.print(s+" "));
        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length1 = o1.length();
                int length2 = o2.length();
                if (length1 == length2){
                    return o1.compareTo(o2);
                }
                return length1 - length2;
            }
        });

        Arrays.stream(a).forEach(s -> System.out.print(s+" "));
    }
}
