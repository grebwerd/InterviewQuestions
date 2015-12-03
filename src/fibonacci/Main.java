package fibonacci;

public class Main {

	public static void main(String[] args) {
		int n = 5;
		System.out.println("The value of the first " + n + " values of the fib sequence " + Main.fibForLoop(n));
		
		System.out.println("The value of the first " + n + " values of the fib sequence " + Main.fibRecursive(n));
	}

	
	public static int fibForLoop(int val){
		int ret = 0;
		int second = 0;
		int first = 0;
		for(int i = 0; i < val; i++){
			if( i == 0 ){
				ret = first = 1;
				System.out.println("The value of first is " + first);
			}else if(i == 1){
				ret = second = 1;
				System.out.println("The value of second is " + second);
			}
			else{
				second = first;
				first = ret;
				ret = first + second;
				System.out.println("The value of first is " + first + " and the value of second is " + second);
			}
			System.out.println("The value of ret is " + ret);
		}
		return ret;
	}
	
	public static int fibRecursive(int n){
		if( n == 0 ){
			return 0;
		}else if( n == 1){
			return 1;
		}
        return fibRecursive(n-1) + fibRecursive(n-2);
	}
	
}
