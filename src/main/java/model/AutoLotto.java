package model;

import dto.AutoLottoDTO;
import dto.AutoLottoResultDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class AutoLotto {
    final static int PRICE = 1000;
    final static int[] PRIZE = {5000, 50000, 150000, 200000000};

    static int inputMoney;
    static List<LottoTicket> lottoTickets = new ArrayList<>();
    static int[] numberOfWinner = new int[6];
    static int[] matchNumCount = new int[7];

    public static void setInputMoney(int money) {
        inputMoney = money;
    }

    public static void buyAutoLottoTicket() {
        for (int i = 0; i < inputMoney / PRICE; i++) {
            lottoTickets.add(new LottoTicket());
        }
    }

    public static void buyManualLottoTicket(String numString) {
        lottoTickets.add(new LottoTicket(numString));
    }

    public static void setNumberOfWinner(String winnerString) {
        StringTokenizer stringTokenizer = new StringTokenizer(winnerString, ", ");
        for (int i = 0; i < 6; i++) {
            numberOfWinner[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numberOfWinner);
    }

    public static void countMatchNum() {
        for (int i = 0; i < lottoTickets.size(); i++) {
            matchNumCount[lottoTickets.get(i).checkWinner(numberOfWinner)]++;
        }
    }

    public double calculateEarningRate() {
        double sum = 0;
        for (int i = 3; i < 7; i++) {
            sum = sum + matchNumCount[i] * PRIZE[i - 3];
        }
        return sum / inputMoney;
    }

    public AutoLottoDTO toAutoLottoDTO() {
        return new AutoLottoDTO(inputMoney / PRICE, lottoTickets);
    }

    public AutoLottoResultDTO toResultDto() {
        return new AutoLottoResultDTO(matchNumCount, calculateEarningRate());
    }

}
