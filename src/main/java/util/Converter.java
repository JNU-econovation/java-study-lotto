package util;

import model.Lotto;
import model.LottoNo;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<Lotto> splitNumbers(List<String> inputs) {
        List<Lotto> lottoList = new ArrayList();
        for (String input : inputs) {
            lottoList.add(new Lotto(convertIntegerToLottoNo(splitNumbers(input))));
        }
        return lottoList;
    }

    public static List<LottoNo> convertIntegerToLottoNo(List<Integer> integerNumbers) {
        List<LottoNo> lottoNoList = new ArrayList();
        for (int integerNumber : integerNumbers) {
            lottoNoList.add(new LottoNo(integerNumber));
        }
        return lottoNoList;
    }

    public static List<Integer> splitNumbers(String input) {
        String[] numbers = input.replaceAll(" ", "").split(",");
        return convertStringToInt(numbers);
    }

    private static List<Integer> convertStringToInt(String[] numbers) {
        List<Integer> winningNumbers = new ArrayList();

        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    public static List<Integer> lottoNoToInteger(List<LottoNo> winningLottoNumbers) {
        List<Integer> integerList = new ArrayList<>();
        for (LottoNo winningLottoNumber : winningLottoNumbers) {
            integerList.add(winningLottoNumber.getLottoNo());
        }
        return integerList;
    }
}
