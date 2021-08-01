package coin;

import coin.Coin;

import java.io.Serializable;

public class USD extends Coin implements Serializable {
    final double value=0.28;
    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double d) {
        double result=  getValue()*d;
        return result;
    }
}