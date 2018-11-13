package utils;

import model.LottoNo;

import java.util.ArrayList;
import java.util.List;

public class ManualTicketGenerator {

    public static List<LottoNo> issue(String manualBalls) {
        List<LottoNo> ticket = new ArrayList<>();
        String[] manualBallList = manualBalls.split(", ");
        if (manualBallList.length != 6) throw new RuntimeException();

        String temp = "";
        for (String manualBall : manualBallList) {
            if (temp.equals(manualBall)) throw new RuntimeException();
            ticket.add(new LottoNo(Integer.parseInt(manualBall)));
            temp = manualBall;
        }
        return ticket;
    }
}