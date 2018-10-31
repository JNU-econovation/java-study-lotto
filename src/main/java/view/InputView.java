package view;

import java.util.Scanner;

public class InputView {

    public static int putMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static String putWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
