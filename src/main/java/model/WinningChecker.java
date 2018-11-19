package model;

import dto.LottoListDTO;
import dto.WinningCheckerDTO;
import dto.WinningLottoDTO;
import util.Converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningChecker {
    private static final int PERCENT = 100;
    private static float profitRate;
    private static Map<String, Integer> winningList;

    public WinningChecker() {
        winningList = new HashMap<>();
        winningList.put("FIRST", 0);
        winningList.put("SECOND", 0);
        winningList.put("THIRD", 0);
        winningList.put("FOURTH", 0);
        winningList.put("FIFTH", 0);
    }

    private void setWinningList(Lotto lotto, int numberOfCorrect, int bonusNumber) {
        if (WinningInfo.FIRST.getCorrectCount() == numberOfCorrect) {
            winningList.put("FIRST", winningList.get("FIRST") + 1);
        }
        if (WinningInfo.SECOND.getCorrectCount() == numberOfCorrect && isContainsBonusNumber(lotto, bonusNumber)) {
            winningList.put("SECOND", winningList.get("SECOND") + 1);
        }
        if (WinningInfo.THIRD.getCorrectCount() == numberOfCorrect + checkContainsBonusNumber(lotto, bonusNumber)) {
            winningList.put("THIRD", winningList.get("THIRD") + 1);
        }
        if (WinningInfo.FOURTH.getCorrectCount() == numberOfCorrect + checkContainsBonusNumber(lotto, bonusNumber)) {
            winningList.put("FOURTH", winningList.get("FOURTH") + 1);
        }
        if (WinningInfo.FIFTH.getCorrectCount() == numberOfCorrect + checkContainsBonusNumber(lotto, bonusNumber)) {
            winningList.put("FIFTH", winningList.get("FIFTH") + 1);
        }
    }

    public void checkResult(LottoListDTO lottoListDTO, WinningLottoDTO winningLottoDTO) {

        for (int i = 0; i < lottoListDTO.getLottoList().size(); i++) {
            int numberOfCorrect = checkNumberOfCorrectInLotto(lottoListDTO.getLottoList().get(i), winningLottoDTO.getWinningLottoNumbers());
            setWinningList(lottoListDTO.getLottoList().get(i), numberOfCorrect, winningLottoDTO.getBonusNumber());
        }
        profitRate = calculateProfitRate(lottoListDTO.getMoney());
        toWinningCheckerDTO();
    }

    private int checkNumberOfCorrectInLotto(Lotto lotto, List<LottoNo> winningLottoNumbers) {
        int numberOfCorrect = 0;

        for (LottoNo winningLottoNo : winningLottoNumbers) {
            numberOfCorrect += checkContainsNumber(lotto, winningLottoNo.getLottoNo());
        }

        return numberOfCorrect;
    }

    private int checkContainsNumber(Lotto lotto, int number) {
        if (Converter.lottoNoToInteger(lotto.getLottoNumbers()).contains(number)) {
            return 1;
        }
        return 0;
    }

    private int checkContainsBonusNumber(Lotto lotto, int bonusNumber) {
        if (Converter.lottoNoToInteger(lotto.getLottoNumbers()).contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean isContainsBonusNumber(Lotto lotto, int bonusNumber) {
        return Converter.lottoNoToInteger(lotto.getLottoNumbers()).contains(bonusNumber);
    }

    private float calculateProfitRate(int money) {
        int profit = 0;

        for (int i = 0; i < winningList.size(); i++) {
            profit += winningList.get(WinningInfo.getRank(i)) * WinningInfo.values()[i].getBenefit();
        }


        return ((float) profit / money) * PERCENT;
    }


    public WinningCheckerDTO toWinningCheckerDTO() {
        return new WinningCheckerDTO(profitRate, winningList);
    }
}