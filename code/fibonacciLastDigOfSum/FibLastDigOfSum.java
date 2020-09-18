import java.util.Scanner;

public class FibLastDigOfSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(getLasDigitOfSumOfFibNum(n));
        in.close();
    }

    /*
     * The sum of a fibonacci number can be found by F(n+2)-F(2)
     * To get the last digit we need to do modulus operation by 10
     * So, (F(n+2)-F(2)) mod 10 which is equivalent to F(n+2) mod 10 - f(2) mod 10
     * We know that F(2) mod 10 = 1, so we only need to find out F(n+2) mod 10
     * We can use Pisano Period to calculate that. We also know that Pisano period for
     * 10 is 60. 
    */
    public static int getLasDigitOfSumOfFibNum(long n){
        n+=2;
        n %= 60;
        // the remainder for 0, 1 fibonacci number is 0 and 1
        // these are set as previous and current respectively
        // i = 2 because we already taken remainder of first two
        // fib numbers as previous and current
        int previous=0, current=1, temp =0, i=2;
        for(;i<=n; i++){
            temp = current;
            current = (previous + current) % 10;
            previous = temp;
        }
        // current holds the remainder of F(n+2), 
        // we are deducting 1 because F(2) mod 10 is 1
        return (current -1+10)%10;
    }

}
