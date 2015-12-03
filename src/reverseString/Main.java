
package reverseString;

public class Main {
	public static void main(String[] args) {

		System.out.println("The reverse string is " + Main.reverseString(null));
		System.out.println("The reverse string is " + Main.reverseString(""));
		System.out.println("The reverse string is " + Main.reverseString("a"));
		System.out.println("The reverse string is " + Main.reverseString("12"));
		System.out.println("The reverse string is " + Main.reverseString("123"));
		
	}
	
	public static String reverseString(String input){
		
		if( input == null || input.isEmpty() || input.length() == 1){
			return input;
		}
		
		String retval = "";
		System.out.println("The input is " + input.length() + " long");
		System.out.println("The char at the last index is " + input.charAt(input.length()-1));
		for(int i = input.length()-1; i >= 0; i--){
			System.out.println(input.charAt(i));
			retval+=input.charAt(i);
		}
		
		return retval;
		
	}
}
