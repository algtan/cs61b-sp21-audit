package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTests {
    @Test
    public void sameNumber() {
        Integer a = 128;
        Integer b = 128;

        boolean actualResult = Flik.isSameNumber(a, b);

        assertTrue(actualResult);
    }
}
