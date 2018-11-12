package lotto.dto;

import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class LottoListDTO {
    private List<LottoDTO> LottoList;

    public LottoListDTO(List<LottoDTO> LottoList) {
        this.LottoList = LottoList;
    }

    public List<LottoDTO> getLottoList() { return LottoList; }
}
