package model;

import dto.WinningLottoDTO;

import java.util.List;

public class WinningLotto {
    private List<LottoNo> winningLottoNumbers;
    private int bonusNumber;

    public WinningLotto(List<LottoNo> winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningLottoDTO toWinningLottoDTO() {
        return new WinningLottoDTO(winningLottoNumbers, bonusNumber);
    }
}
