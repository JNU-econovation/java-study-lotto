package dto;

import model.Lotto;

import java.util.List;

public class LottoDTO {
    private List<Lotto> lottos;

    public LottoDTO(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List getLottos() {
        return lottos;
    }
}
