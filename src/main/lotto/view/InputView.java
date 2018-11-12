package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static ArrayList<Integer> inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winningLottoString = scanner.nextLine().replaceAll(" ", "").split(",");
        ArrayList<Integer> winningLotto = new ArrayList<>();
        for (int i = 0; i < winningLottoString.length; i++) {
            winningLotto.add(Integer.parseInt(winningLottoString[i]));
        }
        return winningLotto;
    }
}
