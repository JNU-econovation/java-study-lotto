package view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int putPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String putWinNumber() {
        System.out.println("지난 주 당첨번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
