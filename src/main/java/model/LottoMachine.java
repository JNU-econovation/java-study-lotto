package model;

import dto.LottoDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    static final int MINIMUMLOTTONUMBER = 1;
    static final int MAXIMUMLOTTONUMBER = 45;
    static final int NUMBER_OF_LOTTO_ELEMENT = 6;
    static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoMachine() {
    }

    public void buyLotto(int inputMoney) {
        for (int i = 0; i < inputMoney / LOTTO_PRICE; i++) {
            lottos.add(new Lotto(generateLotto()));
        }
    }

    public List<Integer> generateLotto() {
        List<Integer> shuffleNumbers = new ArrayList<Integer>();
        List<Integer> numbers;
        for (int i = MINIMUMLOTTONUMBER; i <= MAXIMUMLOTTONUMBER; i++) {
            shuffleNumbers.add(i);
        }
        Collections.shuffle(shuffleNumbers);
        numbers = shuffleNumbers.subList(0, NUMBER_OF_LOTTO_ELEMENT);
        Collections.sort(numbers);
        return numbers;
    }

    public LottoDTO lottoDTO() {
        return new LottoDTO(lottos);
    }
}