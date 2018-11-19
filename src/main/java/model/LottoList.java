package model;

import dto.LottoListDTO;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList;
    private int money;

    public LottoList(List<Lotto> lottoList, int money) {
        this.lottoList = lottoList;
        this.money = money;
    }

    public LottoListDTO toLottoListDTO() {
        return new LottoListDTO(lottoList, money);
    }
}
