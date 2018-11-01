package utils;

import model.LottoNo;

import java.util.ArrayList;
import java.util.List;

public class ManualTicketGenerator {

    public static List<LottoNo> issue(String s) {
        List<LottoNo> numbers = new ArrayList<>();
        //예외처리코드 추가하기

        for (String number : s.split(", ")) {
            numbers.add(new LottoNo(Integer.parseInt(number)));
        }
        return numbers;
    }
    /*
    public static List<LottoNo> toList(String s) {
        for (String number : s.split(", ")) {
            numbers.add(new LottoNo(Integer.parseInt(number)));
        }
        return numbers;
    }
    */
}
