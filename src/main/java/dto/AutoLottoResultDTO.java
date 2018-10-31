package dto;

public class AutoLottoResultDTO {
    static int[] matchNumCount;
    static double earningRate;

    public AutoLottoResultDTO(int[] matchNumCount, double earningRate) {
           this.matchNumCount = matchNumCount;
           this.earningRate = earningRate;
    }

    public int[] getMatchNumCount() {
        return matchNumCount;
    }

    public double getEarningRate(){
        return earningRate;
    }
}
