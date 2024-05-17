import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void calculate_givenNull_returnsZero()  //B)0 create test
    {
        //Nothing to Arrange
        Integer res=StringCalculator.calculate("");
        Assertions.assertEquals(0,res);
    }

    @Test
    void calculate_givenNumber_returnsNumber() { //C) 0 create test
        Integer res=StringCalculator.calculate("13");
        assertEquals(13,res);
    }

    @Test
    void calculate_given2NumbersCommaDelimited_returnsSum() { //D) 0 create test
        Integer res=StringCalculator.calculate("333,333");
        assertEquals(666,res);
    }
    @Test
    void splitNumbers_givenNumbersCommaDelimited_returnsSum() { //D) 2 create test for new method
        //debate: should we test private methods?
        int[] r={1,3,4};
        int[] split=StringCalculator.splitNumbers("1,3,4");
        assertArrayEquals(r,split);
    }

    @Test
    void calculate_given2NumberNewlineDelimited_returnsSum() { //E) 0 create test
        Integer res=StringCalculator.calculate("128\n64");
        assertEquals(192,res);
    }

    @Test
    void calculate_given3NumbersDelimited_returnsSum() { //F) 0 create test
        Integer res=StringCalculator.calculate("31\n33,64");
        assertEquals(128,res);
    }

    @Test
    void calculate_givenNegativeNumber_throwsException() { //G) 0 create test
//        assertThrows(NumberFormatException.class, () -> StringCalculator.calculate("5,-1"));
        try {
            StringCalculator.calculate("5,-1");
            assertTrue(false,"Not an exception thrown");
        } catch (NumberFormatException e) {
            assertTrue(true); //not really needed
        }
    }

    @Test
    void calculate_givenGT1000_ignoresNumber() { //H) 0 create test
        Integer res=StringCalculator.calculate("5,1001");
        assertEquals(5, res);
    }


}
