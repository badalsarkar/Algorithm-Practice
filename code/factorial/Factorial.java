
public class Factorial {
    public static int getFactorial(int number){
        if(number == 1 || number == 0){
            return 1;
        }
        else{
            return number * getFactorial(number-1);
        }
    }
}
