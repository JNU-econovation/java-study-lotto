package dto;

import model.Lotto;

import java.util.List;

public class LottoGameDTO {
    private List<Lotto> lottoList;
    private int autoCount;
    private int manualCount;

    public LottoGameDTO(List<Lotto> lottoList, int autoCount, int manualCount) {
        this.lottoList = lottoList;
        this.autoCount = autoCount;
        this.manualCount = manualCount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }
}