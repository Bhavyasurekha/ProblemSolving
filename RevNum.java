import java.util.*;
public class Revnum {
    
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int last=0;
        while(n>0){
            last=last*10+(n%10);
            n=n/10;
        }
        System.out.print(last);
    }
    
}
