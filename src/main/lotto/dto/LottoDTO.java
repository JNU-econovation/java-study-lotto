package lotto.dto;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class LottoDTO {

    private List<Integer> lottoNumbers;;

    public LottoDTO(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public String drawLottoNumber() {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(joining(", "));
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
