package model;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            stringBuilder.append(String.format("%d, ", numbers.get(i)));
        }
        stringBuilder.append(numbers.get(numbers.size() - 1) + "]");
        return stringBuilder.toString();
    }
}
