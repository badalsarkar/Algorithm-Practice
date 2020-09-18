import java.util.Scanner;

public class MaxPaireWiseProduct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            int n = in.nextInt();
            int[] data= new int[n];
            while(n>0 && in.hasNext()){
                data[--n]=in.nextInt();
            } 
            in.nextLine();
            System.out.println(getProduct(data));
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
        
    }

    public static long getProduct(int[] data){
        java.util.Arrays.sort(data);
        int length = data.length;
        if(length>1){
            return (long)data[length-1]*(long)data[length-2];
        }
        else if(length==1){
            return data[length-1];
        }
        else{
            return -1;
        }
    }

}
