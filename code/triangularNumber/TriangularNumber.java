
public class TriangularNumber {
    public static int getTerm(int position){
        int term=0;
        if(position==1){
            return position;
        }
        else{
             term = position+getTerm(position-1);
        }
        return term;
    }
}
