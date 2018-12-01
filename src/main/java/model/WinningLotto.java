package model;

import util.StringParser;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {

    private Set<Integer> winNumber = new HashSet<>();

    public void setWinNumber(String winNumber){
        this.winNumber = StringParser.parseToNumbers(winNumber);
    }

    public boolean contains(Integer integer) {
        return winNumber.contains(integer);
    }
}
