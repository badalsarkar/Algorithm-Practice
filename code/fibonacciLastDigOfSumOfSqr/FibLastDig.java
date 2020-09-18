import java.util.Scanner;

public class FibLastDig {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(getLastDigitOfSumOfSquare(n));
        in.close();
    }

    /*
     * We know that the sum of square of fibonacci number is F(n)* F(n+1)
     * We will use the pisano period to find the last digit without calculating
     * the fibonacci number itself
     * We also know that pisano period for 10 is 60
    */
    public static int getLastDigitOfSumOfSquare(long n){
        if(n==0) return 0;
        if(n==1) return 1;
        n%=60;
        int previous =0,current =1, temp =0, i=2;
        if(n<=1){
            current =(int) n;
        }
        else{
            for(;i<=n; i++){
                temp = current;
                current = (previous + current)%10;
                previous = temp;
            }
        }
        /*
         * To get the remainder of n+1 calculate one more time
        */
        int nextRemainder = (current+previous)%10;
        return (current*nextRemainder)%10;
    }

}
