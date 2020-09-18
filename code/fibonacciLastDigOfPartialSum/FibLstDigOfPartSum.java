import java.util.Scanner;

public class FibLstDigOfPartSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long m = in.nextLong();
        long n = in.nextLong();
        System.out.println(getLastDigit(n, m));
        in.close();
    }
    // sum of fibonacci range is F(n+2) - F(m+1), where m<=n
    // to get remainder of the sum, we get remainder of F(n+2) and F(m+1)
    // using pisano period of 60
    // constraints 0<= m <= n <= 10^14
    public static int getLastDigit(long n, long m){
        n+=2;
        m+=1;
        int current=1, previous =0, temp =0, i =2, mRemainder=0;
        if(m<=2){
            mRemainder=1;
        }
        else{
            m%=60;
        // calculate remainder for F(m+1)
            for(;i<=m; i++){
                temp = current;
                current = (previous + current) % 10;
                previous = temp;
            }
            mRemainder = current;
        }
        if(n==m){
            return mRemainder;
        }
        else{
            n%=60;
        // reset
            previous =0;
            current = 1;
            for(i=2; i<=n ; i++){
                temp = current;
                current = (previous + current +10) % 10;
                previous = temp;
            }
        }
        return (current - mRemainder+10)%10;
    }
}
