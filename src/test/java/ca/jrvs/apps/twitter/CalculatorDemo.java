package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.example.Calculator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorDemo {

    private Calculator calx;

    @BeforeClass //run before every single test method.....5 method...5 times....run
    public static void setupClass() {

    }

    @Before  //run before every single test method.....5 method...5 times....run
    public void setup() {
        Calculator cal4 = new Calculator();
    }


    @org.junit.Test  //Junit will do some imp stuff ..reading @test word
    public void evaluateMyMathTask() {
        System.out.println("hello test world"); //here is no main method, so none will evaluate or make main method.
        //so @test is imp to tell comelier that go for test...

        Calculator cal;
        cal = new Calculator();
        int sum = cal.evaluate("1+2");
        System.out.println(sum);

    }

    @Test
    public void evaluateHappyPath() {
        int sum = calx.evaluate("1+2");

        assertNotNull(sum);

        //approach 1
        if (sum == 3) {
            System.out.println("i'm happy");
        } else {
            throw new RuntimeException("Bad");
        }

        //approach 2
        assertTrue(3 == sum);

        //approach 3
        assertEquals(3, sum);
        assertEquals(2, sum);
    }

    @Test
    public void evaluateSadPath() {
        try {
            int sum = calx.evaluate("1.1+2");
            fail();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }



}