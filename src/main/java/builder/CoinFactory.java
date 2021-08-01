package builder;


import coin.Coin;
import coin.EUR;
import coin.ILS;
import coin.USD;

public class CoinFactory {
    public static Coin getCoinInstance(Coins currency){
        switch (currency){
            case ILS:
                return new ILS();
            case USD:
                return  new USD();
            case EUR:
                return  new EUR();
            default:
                return null;
        }
    }
}