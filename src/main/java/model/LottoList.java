package model;

import dto.LottoListDTO;
import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList = new ArrayList<>();

    public void addLottoToList(Lotto lotto) {
        lottoList.add(lotto);
    }


    public LottoListDTO toLottoListDTO() {
        return new LottoListDTO(lottoList);
    }
}
