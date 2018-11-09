package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputPayment() {
        System.out.println("금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }
}
