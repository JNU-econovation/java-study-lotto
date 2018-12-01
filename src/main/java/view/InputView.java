package view;

import util.Converter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        if (money < 0) throw new InputMismatchException();
        return money;
    }

    public static int inputManualLotto() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> inputManualLottoNumbers(int count) {
        List<String> manualLottoList = new ArrayList();
        scanner.nextLine(); //
        if (count != 0) {
            System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
            for (int i = 0; i < count; i++) {
                manualLottoList.add(scanner.nextLine());
                if (Converter.splitNumbers(manualLottoList.get(i)).size() != 6) throw new InputMismatchException();
            }
        }

        return manualLottoList;
    }

    public static String inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();
        if(Converter.splitNumbers(winningNumbers).size() != 6) throw new InputMismatchException();
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요");
        return scanner.nextInt();
    }
}
