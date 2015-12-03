package rototeArray;

public class Main {
	
	
	public static void main(String[] args){
		Main m = new Main();
		int[] nums = {1,2,3};
		m.rotate(nums, 2);
	}
	 public void rotate(int[] nums, int k) {
		    
		    
		    if(nums.length == 1){
		        return;
		    }
		    
		    if(k >= nums.length){
		        k = k % nums.length;
		    }
		     
		     int[] temp = new int[k];
		     int count = 0;
		     for(int i = nums.length-k; count < k; i++){
		    	 System.out.println("STORING THE LAST K VALUES OF THE ORIGINAL ARRAY");
		    	 System.out.println("The value of i is " + i);
		         temp[count] = nums[i];
		        System.out.println("The value of nums[i] is " + nums[i]);
		        System.out.println("The value of temp[count] is " + temp[count]);
		         count++;
		     } 
		     
		     System.out.println();
		     System.out.print("ROTATING THE FIRST K VALUES OF THE ORIGINAL ARRAY");
		     for(int i = nums.length-1; i > k-1; i--){
		    	
		    	 System.out.println("The value of nums[i] is " + nums[i]);
		    	 System.out.println("The value of nums[i-k] is " + nums[i-k]);
		             nums[i] = nums[i-k];
		     }
		     System.out.println();
		     System.out.println("ADDING THE LAST k VALUES BACK TO THE FIRST K VALUES OF THE ARRAY");
		     for(int i = 0; i < k; i++){
		    	
		    	 System.out.println("The value of temp[i] is " + temp[i]);
		         nums[i] = temp[i];
		     }
			 
		     for(int i : nums){
		    	 System.out.print(i + "");
		     }
			  
		    }

}
