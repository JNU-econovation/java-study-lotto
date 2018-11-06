package model;

public class LottoStore {

    static final int PRICE = 1000;
    public int inputMoney;
    int numberOfBought;

    public LottoStore(int inputMoney) {
        this.inputMoney = inputMoney;
        this.numberOfBought = inputMoney / PRICE;
        System.out.println(numberOfBought + "개를 구매했습니다.");
    }

    public int[][] buyLotto() {
        LottoMachine lottoMachine = new LottoMachine(numberOfBought);
        return lottoMachine.printOutLottos();
    }
}
