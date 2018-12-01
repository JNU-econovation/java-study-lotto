package utils;

import model.LottoNo;

import java.util.*;
import java.util.stream.Collectors;


public class AutoTicketGenerator {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private final static int NUMBER_OF_ENTRY = 6;

    public static List<LottoNo> createBalls() {
        List<LottoNo> balls = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            balls.add(new LottoNo(i));
        }
        return balls;
    }

    public static List<LottoNo> issue() {
        List<LottoNo> ticket;
        List<LottoNo> balls = createBalls();

        Collections.shuffle(balls);
        ticket = balls.subList(0, NUMBER_OF_ENTRY);

        return ticket.stream()
                .sorted(Comparator.comparing(LottoNo::getNumber))
                .collect(Collectors.toList());
    }
}