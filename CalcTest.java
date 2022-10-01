import utils.Calc;
import java.io.*;

public class CalcTest {

    public static void passed(String message){
        System.out.println("Test passed: "+message);
    }

    public static void fail(String message){
        System.out.println("Test failed: "+message);
    }
    public static void main(String[] args) {
        double first = Calc.factorial(5);
        double second = Calc.factorial(0);
        double third = Calc.factorial(-5);
        if(first == 120){
            CalcTest.passed("Calc.factorial(5): "+first);
        }
        else{
            CalcTest.fail("Calc.factorial(5): "+first);
        }

        if(second == 1){
            CalcTest.passed("Calc.factorial(0): "+second);
        }
        else{
            CalcTest.fail("Calc.factorial(0): "+second);
        }

        if(third == -1){
            CalcTest.passed("Calc.factorial(-5): "+third);
        }
        else{
            CalcTest.fail("Calc.factorial(-5): "+third);
        }
    }
}
