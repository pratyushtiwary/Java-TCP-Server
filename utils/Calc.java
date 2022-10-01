package utils;

public class Calc{
    public static double factorial(int x){
        double fact = 1;

        if (x < 0) return -1;

        while(x > 0){
            fact *= x;
            x -= 1;
        }

        return fact;
    }
}