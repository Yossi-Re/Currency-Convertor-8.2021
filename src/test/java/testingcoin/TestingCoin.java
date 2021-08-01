package testingcoin;

import coin.Coin;
import coin.ILS;
import org.junit.Before;
import org.junit.Test;
import program.Main;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestingCoin {
    Coin coin=null;
    @Before
    public void setUp(){
        coin=new ILS();
    }
    @Test
    public void resultIsValid(){
        double result = coin.calculate(2000);
        assertEquals(result, 7142.857, 0.001);
    }

    @Test
    public void valueToConvert(){
        InputStream in= new ByteArrayInputStream("1000".getBytes());
        System.setIn(in);
        Scanner scanner=new Scanner(System.in);
        double a = Main.notNumericAmount(scanner);
        assertEquals(a, 1000, 0.001);

    }
}