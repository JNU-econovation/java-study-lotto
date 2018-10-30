package model;

import dto.AutoLottoDTO;
import dto.AutoLottoResultDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class LottoGame {
    public static final int MAX_NUMBER = 6;
    public final static int PRICE = 1000;
    public final static int[] PRIZE = {5000, 50000, 150000, 200000000};

    public static int inputMoney;
    public static List<LottoTicket> lottoTickets = new ArrayList<>();
    public static int[] numberOfWinner = new int[6];
    public static int[] numberOfMatch = new int[7];

    public LottoGame(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public void buyAutoLottoTicket() {
        for (int i = 0; i < inputMoney / PRICE; i++) {
            lottoTickets.add(new LottoTicket());
        }
    }

    public void buyManualLottoTicket(String numString) {
        lottoTickets.add(new LottoTicket(numString));
    }

    public void setNumberOfWinner(String winnerString) {
        StringTokenizer stringTokenizer = new StringTokenizer(winnerString, ", ");
        for (int i = 0; i < 6; i++) {
            numberOfWinner[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numberOfWinner);
        checkMatch();
    }

    public void checkMatch() {
        for (int i = 0; i < lottoTickets.size(); i++) {
            numberOfMatch[countMatch(lottoTickets.get(i))]++;
        }
    }

    public int countMatch(LottoTicket lottoTicket) {
        int count = 0;
        for (int i = 0; i < MAX_NUMBER; i++) {
            if (lottoTicket.isContain(numberOfWinner[i])) count++;
        }

        return count;
    }

    public double calculateEarningRate() {
        double sum = 0;
        for (int i = 3; i < 7; i++) {
            sum = sum + numberOfMatch[i] * PRIZE[i - 3];
        }
        return sum / inputMoney;
    }

    public AutoLottoDTO toAutoLottoDTO() {
        return new AutoLottoDTO(lottoTickets);
    }

    public AutoLottoResultDTO toResultDto() {
        return new AutoLottoResultDTO(numberOfMatch, calculateEarningRate());
    }

}
