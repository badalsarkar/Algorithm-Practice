import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            long a = in.nextLong();
            long b = in.nextLong(); 
            in.nextLine();
            System.out.println(findGCD(a, b));
        }
        catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        finally{
            in.close();
        }
    }

    public static long findGCD(long a, long b){
        try{
            long remainder =a%b;
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
