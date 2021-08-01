package coin;

public abstract class Coin implements ICalculate {
    public abstract double getValue();

    @Override
    public abstract double calculate(double d);

}