package view;

import java.util.Scanner;

public class InputView {
    private static final int PRICE = 1000;

    public static int putMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = new Scanner(System.in).nextInt();
        int count = money / PRICE;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    public static String putWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
