import java.util.Scanner;

// Problem Introduction
// Recall the definition of Fibonacci sequence: F 0 = 0, F 1 = 1, and F i = F i−1 + F i−2 for
// i ≥ 2. Your goal in this problem is to implement an efficient algorithm for computing
// Fibonacci numbers.
// 
// Problem Description
// Task: Given an integer n, find the nth Fibonacci number F n .
// Input Format: The input consists of a single integer n.
// Constraints: 0 ≤ n ≤ 45.
// Output Format. Output F n .
//
// Time complexity: O(n)
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
        in.close();
    }

    private static long getFibonacciNumber(int n){
        if(n<=1) return n;
        long fibPrevious=0;
        long fibCurrent=1;
        for(int i = 2; i<=n; i++){
            long temp = fibCurrent;
            fibCurrent=fibPrevious+ fibCurrent;
            fibPrevious=temp;
        }
        return fibCurrent;
    }
}
