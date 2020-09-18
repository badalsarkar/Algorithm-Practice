import java.util.Scanner;

/*
 * The goal in this problem is to find the minimum number of coins needed to change the input value
 * (an integer) into coins with denominations 1, 5, and 10.
 *
 * Constraint: 1<= m <= 10^3
*/

public class MoneyChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            int m = in.nextInt();
            System.out.println(getChange(m));
        }
        catch(NumberFormatException ex){
            System.out.println("Invalid number");
        }
        in.close();
    }

    private static int getChange(int m){
        int count=0;
        int coin10=10;
        int coin5=5;
        int coin1=1;
        while(m>0){
            if(m>=coin10){
                m-=coin10;
                count++;
            }
            else if(m>=coin5){
                m-=coin5;
                count++;
            }
            else{
                m-=coin1;
                count++;
            }
        }
        return count;
    }
}
