package view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputNumberOfManualTicket() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요");
        int numberOfManualTicket = Integer.parseInt(scanner.nextLine());

        System.out.println("\n수동으로 구매할 로또 번호를 입력해 주세요");
        StringBuilder manualLottoNumberString = new StringBuilder();
        for (int i = 0; i < numberOfManualTicket; i++) {
            String temp = scanner.nextLine();
            manualLottoNumberString.append(temp).append("\n");
        }

        return manualLottoNumberString.toString();
    }

    public static String inputWinNumber() {
        StringBuilder winNumberString = new StringBuilder();

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        winNumberString.append(scanner.nextLine()).append(", ");

        System.out.println("보너스 볼을 입력해 주세요");
        winNumberString.append(scanner.nextLine());

        return winNumberString.toString();
    }
}
