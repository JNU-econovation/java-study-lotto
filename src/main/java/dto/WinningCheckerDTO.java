package dto;

import model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningCheckerDTO {
    private static List<Lotto> lottoListCorrecting3Numbers;
    private static List<Lotto> lottoListCorrecting4Numbers;
    private static List<Lotto> lottoListCorrecting5Numbers;
    private static List<Lotto> lottoListCorrecting6Numbers;

    public WinningCheckerDTO(List<Lotto> lottoListCorrecting3Numbers, List<Lotto> lottoListCorrecting4Numbers, List<Lotto> lottoListCorrecting5Numbers, List<Lotto> lottoListCorrecting6Numbers) {
        this.lottoListCorrecting3Numbers = lottoListCorrecting3Numbers;
        this.lottoListCorrecting4Numbers = lottoListCorrecting4Numbers;
        this.lottoListCorrecting5Numbers = lottoListCorrecting5Numbers;
        this.lottoListCorrecting6Numbers = lottoListCorrecting6Numbers;
    }

    public static List<Lotto> getLottoListCorrecting3Numbers() {
        return lottoListCorrecting3Numbers;
    }

    public static List<Lotto> getLottoListCorrecting4Numbers() {
        return lottoListCorrecting4Numbers;
    }

    public static List<Lotto> getLottoListCorrecting5Numbers() {
        return lottoListCorrecting5Numbers;
    }

    public static List<Lotto> getLottoListCorrecting6Numbers() {
        return lottoListCorrecting6Numbers;
    }
}