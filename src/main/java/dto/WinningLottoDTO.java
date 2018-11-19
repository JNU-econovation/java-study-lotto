package dto;

import model.LottoNumber;

import java.util.List;

public class WinningLottoDTO {
    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLottoDTO(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
