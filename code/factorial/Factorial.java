
public class Factorial {
    public static int getFactorial(int number){
        // it returns -1 to denote that the input in invalid
        if(number<0){
            return -1;
        }
        if(number == 1 || number == 0){
            return 1;
        }
        else{
            return number * getFactorial(number-1);
        }
    }
}
