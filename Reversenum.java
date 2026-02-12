import java.util.*;
public class Reversenum {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int last=0;
        while(n>0){
            last=n%10;
            System.out.print(last+" ");
            n=n/10;
        }
    }
    
}
