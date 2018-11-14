package model;

public class Number implements Comparable<Number>{
    int number;

    public Number(int number){
        if(number < 0 || number > 45) throw new IllegalArgumentException();
        this.number = number;
    }

    public int toInteger(){
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return this.number == ((Number)obj).toInteger();
    }

    @Override
    public int compareTo(Number o) {
        return this.number - o.number;
    }
}
