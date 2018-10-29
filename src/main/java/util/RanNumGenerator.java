package util;

import java.util.Random;

public class RanNumGenerator {

    private static Random random = new Random();
    public static int getRanNumber(){
        return (int)(random.nextFloat()*45+1);
    }
}
