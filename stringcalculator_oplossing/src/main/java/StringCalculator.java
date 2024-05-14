import java.util.Arrays;

/**
 * Exercise on TDD: string calculator
 * For each step in the implementation (A,B,C,...) the corresponding code is commented.
 * eg //C) 0 create test     => this is the 0th step for implementing requirement C: writing the test
 * eg //C) 1                 => implementing the code necessary to pass the test
 * eg //C) 2 implement  after failed test for req 1      => changing the implementation because test calculate_givenNull_returnsZero failed
 */
public class StringCalculator {
    /**
     * Useful code snippets to use in the implementation
     */
    public void usefulCode() {
        String s="a:b=c";
        s.split("[:=]");  //returns array {a,b,c}
        String n="5";
        Integer.parseInt(n); // returns integer 5
    }

    /**
     * Calculates the sum of the given numbers
     * @param s contains the numbers
     * @return the sum
     */
    public static int calculate(String s) {
        //return 0; //B)1 implement
        if(s.isEmpty()) return 0; //C)2 implement  after failed test for req 1
        //return Integer.parseInt(s); //C)1 implement
        int[] numbers=splitNumbers(s);  //D)3 implement
        return Arrays.stream(numbers).sum(); //D)3 implement
    }

    /**
     * returns the numbers in a string
     * @param s string containing possibly multiple numbers
     * @return the array of integer numbers represented in the input string
     */
    public static int[] splitNumbers(String s) {  //D)1 implement
        String[] strings = s.split("[,\n]");  //D)1 E)1 implement
        int[] ints=new int[strings.length];
        for (int i=0; i<strings.length;i++) {
            ints[i]=Integer.parseInt(strings[i]);
            if(ints[i]<0) throw new NumberFormatException("Cant be a negative number"); //G)1 implement
            if(ints[i]>1000) ints[i]=0; //H)1 implement
        }
        return ints;
    }
}
