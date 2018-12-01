package dto;

import model.LottoNo;
import java.util.List;

public class WinningLottoDTO {
    private List<LottoNo> winningLottoNumbers;
    private int bonusNumber;

    public WinningLottoDTO(List<LottoNo> winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoNo> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
