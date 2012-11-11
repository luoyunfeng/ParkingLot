import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午4:22
 * To change this template use File | Settings | File Templates.
 */
public class TestParking {
    @Test
    public void textInput(){
        Parking guessNumber = new Parking(100);
        boolean result = guessNumber.input("0000");
        assertEquals(true, result);
    }
    @Test
    public void textOutput(){
        Parking guessNumber = new Parking(100);
        guessNumber.input("A");
        boolean result = guessNumber.output("A");
        assertEquals(true, result);
    }
    @Test
    public void textOutputThenOutPut(){
        Parking guessNumber = new Parking(100);
        guessNumber.input("A");
        boolean result = guessNumber.output("A");
        result = guessNumber.output("A");
        assertEquals(false, result);
    }
    @Test
    public void textEmptyNum(){
        Parking guessNumber = new Parking(100);
        boolean result = guessNumber.getEmptyNum();
        assertEquals(false, result);
    }
    @Test
    public void textEmptyParkGetCar(){
        Parking guessNumber = new Parking(100);
        boolean result = guessNumber.output("AA");
        assertEquals(false, result);
    }
}
