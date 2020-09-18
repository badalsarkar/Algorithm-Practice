import java.util.Scanner;

public class LCM {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        in.nextLine();
        System.out.println(findLCM(a, b));
    }
    public static long findLCM(long a, long b){
        long gcd = findGCD(a, b);
        return (a*b)/gcd;
    }

    private static long findGCD(long a, long b){
        try{
            long remainder = a%b;
            if(remainder==0){
                return b;
            }
            else{
                return findGCD(b, remainder);
            }
        }
        catch(ArithmeticException ex){
            return -1;
        }
    }
}
