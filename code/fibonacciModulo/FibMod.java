import java.math.BigInteger;
import java.util.Scanner;

public class FibMod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            long n = in.nextLong();
            int m = in.nextInt();
            in.nextLine();
            System.out.println(fibMod(n,m));
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        finally{
            in.close();
        }
    }

    private static long fibMod(long n, int m){
        if(n<=1){
            return n;
        }
        //calculate pisano period
        int previous =0, current = 1, pisano =0, i =0, temp =0;
        while(true){
            temp = current;
            current = (previous+current)%m;
            previous= temp;
            pisano++;
            if(previous ==0 && current ==1){
                break;
            }
        };
        n %= pisano;
        if(n<=1) return n;
        previous = 0;
        current = 1;
        for(i=2; i<=n; i++){
            temp = current;
            current = (previous + current)%m;
            previous = temp;
        }
        return current;
    }
}
