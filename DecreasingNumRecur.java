public class Main
{
	public static void main(String[] args) {
		recur(5);
	}
	public static void recur(int n){
	    if(n==0){
	        return;
	    }
	    System.out.println(n);
	    recur(n-1);
	}
}
