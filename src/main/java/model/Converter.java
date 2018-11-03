package model;

public class Converter {

    public static int[] splitNumbers(String input) {
        String[] numbers = input.split(",");
        return convertStringToInt(numbers);
    }

    private static int[] convertStringToInt(String[] numbers) {
        int[] winningNumbers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            winningNumbers[i] = Integer.parseInt(numbers[i]);
        }

        return winningNumbers;
    }
}
