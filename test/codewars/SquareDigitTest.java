package codewars;

import codewars.SquareDigit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SquareDigitTest {
    @Test
    public void test() {
      assertEquals(811181, new SquareDigit().squareDigits(9119));
      assertEquals(111, new SquareDigit().squareDigits(111));
      assertEquals(44, new SquareDigit().squareDigits(22));
      assertEquals(9, new SquareDigit().squareDigits(3));
      assertEquals(404, new SquareDigit().squareDigits(202));
      assertEquals(10000, new SquareDigit().squareDigits(10000));
    }
}
