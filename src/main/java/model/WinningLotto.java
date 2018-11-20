package model;

import dto.WinningLottoDTO;

import java.util.List;

public class WinningLotto {
    private List<LottoNumber> winningLotto;
    private LottoNumber bonusNumber;


    public WinningLotto(List<LottoNumber> winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinningLottoDTO winningLottoDTO() {
        return new WinningLottoDTO(winningLotto, this.bonusNumber);
    }
}
