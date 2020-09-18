import java.util.Scanner;

//Task: Given an integer n, find the last digit of the nth Fibonacci number F n (that is, F n mod 10).
//Input Format: The input consists of a single integer n.
//Constraints: 0 ≤ n ≤ 10 7 .
//Output Format: Output the last digit of F n .
//
//Time complexity: Big O(n)
//
public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            int number = in.nextInt();
            System.out.println(getFibonacciNumber(number));
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        finally{
            in.close();
        }
    }

    private static int getFibonacciNumber(int n){
        if(n<=1) return n;
        int fibP=0;
        int fibPP=1;
        for(int i = 2; i<=n; i++){
            int temp = fibPP;
            fibPP=(fibP+ fibPP)%10;
            fibP=temp;
        }
        return fibPP;
    }
}
