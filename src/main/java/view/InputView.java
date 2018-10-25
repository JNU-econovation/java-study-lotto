package view;

import java.util.Scanner;

public class InputView {
    static final int PRICE_OF_LOTTO = 1000;

    public static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = new Scanner(System.in).nextInt();
        int count = money / PRICE_OF_LOTTO;
        System.out.println(count + "개를 구매했습니다.\n");
        return count;
    }

    public static String putWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
