public class Main
{
	public static void main(String[] args) {
		System.out.println(recur(5));
	}
	public static int recur(int n){
	    if(n==0){
	        return 0;
	    }
	   return n+recur(n-1);
	    
	}
}
