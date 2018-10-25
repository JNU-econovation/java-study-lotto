package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int COUNT_OF_RAFFLE = 6;
    private List<Integer> lottery;

    public Lotto() {
        this.lottery = issue();
    }

    public List<Integer> getAllBalls() {
        List<Integer> balls = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            balls.add(i);
        }
        return balls;
    }

    public List<Integer> issue() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> balls = getAllBalls();

        Collections.shuffle(balls);
        for (int i = 0; i < COUNT_OF_RAFFLE; i++) {
            numbers.add(balls.get(i));
        }
        Collections.sort(numbers);

        return numbers;
    }
}
