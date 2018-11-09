package dto;

import model.Lotto;

import java.util.List;

public class LottoListDTO {
    private List<Lotto> lottoList;

    public LottoListDTO(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }


    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
