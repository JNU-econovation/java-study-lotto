package view;

import java.util.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int readManualCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> readManualBalls(int count) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualBallsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualBallsList.add(scanner.nextLine());
        }
        return manualBallsList;
    }

    public static String readWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int readBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}