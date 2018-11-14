package model;

import dto.LottoResultDTO;
import dto.LottoGameDTO;

import java.util.*;

public class LottoResult {
    static final int NUMBER_OF_BALL = 6;
    static final int INDEX_OF_BONUS_BALL = 7;
    static List<Number> winNumber;

    public LottoResult(String string) {
        winNumber = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(string, ", ");

        while (st.hasMoreTokens()) {
            winNumber.add(new Number(Integer.parseInt(st.nextToken())));
        }
    }

    public LottoResultDTO calculateResult(LottoGameDTO lottoGameDTO) {
        List<LottoTicket> lottoTickets = lottoGameDTO.getLottoTickets();
        HashMap<Rank, Integer> matchCount = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = checkMatch(lottoTicket);
            if (matchCount.containsKey(rank)) {
                matchCount.remove(rank, matchCount.get(rank) + 1);
                continue;
            }
            if (rank != null) matchCount.put(rank, 1);
        }

        float earning = calculateEarnings(matchCount, lottoTickets.size() * lottoGameDTO.getTicketPrice());
        return toLottoResultDTO(matchCount, earning);
    }

    public Rank checkMatch(LottoTicket lottoTicket) {
        int count = 0;
        boolean matchBonus = false;
        for (int i = 0; i < NUMBER_OF_BALL; i++) {
            if (lottoTicket.hasNumber(winNumber.get(i))) count++;
        }
        if (count == 5) {
            if (lottoTicket.hasNumber(winNumber.get(INDEX_OF_BONUS_BALL - 1))) matchBonus = true;
        }

        return Rank.match(count, matchBonus);
    }

    public float calculateEarnings(HashMap<Rank, Integer> matchCount, int inputMoney) {
        int earnings = 0;
        for (Map.Entry<Rank, Integer> elem : matchCount.entrySet()) {
            earnings = elem.getKey().getWinPrize() * elem.getValue();
        }

        return (float) earnings / inputMoney;
    }

    public LottoResultDTO toLottoResultDTO(HashMap<Rank, Integer> matchCount, float earnings) {
        return new LottoResultDTO(matchCount, earnings);
    }
}
