package model;

import dto.LottoDTO;
import utils.Splitor;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoMachine(int inputMoney, List<String> manualLottos) {
        for (int i = 0; i < manualLottos.size(); i++)
            lottos.add(new Lotto(Splitor.stringToIntegerArray(manualLottos.get(i))));
        for (int i = 0; i < inputMoney / LOTTO_PRICE - manualLottos.size(); i++)
            lottos.add(new Lotto());
    }

    public LottoDTO lottoDTO() {
        return new LottoDTO(lottos);
    }
}