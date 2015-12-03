package singleNumber;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.singleNumber(new int[] { 2, 2, 5, 3 });
	}

	public int[] singleNumber(int[] nums) {

		if (nums.length <= 2) {
			return nums;
		}
		
		
		List<Integer> val = new ArrayList<>();

		for (int i : nums) {
			if (val.contains(i)) {
				val.remove(new Integer(i));
			} else {
				val.add(new Integer(i));
			}
		}

		int [] retval = new int[val.size()];
		
		for(int i = 0; i < val.size(); i++){
		      retval[i] = val.get(i);
		}
		
		return retval;
	}
}
