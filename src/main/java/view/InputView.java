package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static int readManualCounts() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static String readManualBalls() {
        return new Scanner(System.in).nextLine();
    }

    public static String readWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public static int readBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }
}
