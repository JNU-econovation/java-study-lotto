package View;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String winnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }
}