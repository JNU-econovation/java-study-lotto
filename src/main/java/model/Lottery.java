package model;

import java.util.*;

public class Lottery {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int NUMBER_OF_ENTRY = 6;
    private List<Integer> ticket;

    public Lottery() {
        this.ticket = issue();
    }

    public List<Integer> createBalls() {
        List<Integer> balls = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            balls.add(i);
        }
        return balls;
    }

    public List<Integer> issue() {
        List<Integer> numbers;
        List<Integer> balls = createBalls();

        Collections.shuffle(balls);
        numbers = balls.subList(0, NUMBER_OF_ENTRY);
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getTicket() {
        return ticket;
    }
}
