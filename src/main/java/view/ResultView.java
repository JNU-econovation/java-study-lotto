package view;


import dto.LottoDTO;

import java.util.Scanner;

public class ResultView {
    public void printLottos(LottoDTO lottoDTO) {
        System.out.println(String.format("%d개를 구매하였습니다.", lottoDTO.getLottos().size()));
        for (int i = 0; i < lottoDTO.getLottos().size(); i++) {
            System.out.println(lottoDTO.getLottos().get(i));
        }
    }

    public String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
