package model;

public class LottoStore {

    static final int PRICE = 1000;
    public int inputMoney;
    public int numberOfBought;

    public LottoStore(int inputMoney) {
        this.inputMoney = inputMoney;
        this.numberOfBought = inputMoney / PRICE;
    }

    public int[][] buyLotto() {
        LottoMachine lottoMachine = new LottoMachine(numberOfBought);
        return lottoMachine.printOutLottos();
    }
}
