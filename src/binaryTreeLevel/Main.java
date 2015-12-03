package binaryTreeLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);

		t1.left = t2;
		t1.right = t3;

		Main m = new Main();
		List<List<Integer>> retval = m.levelOrder(t1);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> treeLevel = new ArrayList<List<Integer>>();

		if (null == root) {
			return treeLevel;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		ArrayList<Integer> rootLevel = new ArrayList<Integer>();
		Map<Integer, List<Integer>> level = new HashMap<Integer, List<Integer>>();

		queue.add(root);
		queue.add(new TreeNode(0));
		while (queue.size() != 0) {
			TreeNode temp = queue.poll();
			TreeNode marker = queue.poll();

			if (null == level.get(marker.val)) {
				level.put(marker.val, new ArrayList<Integer>());
			}

			level.get(marker.val).add(temp.val);

			if (null != temp.left) {
				queue.add(temp.left);
				queue.add(new TreeNode(marker.val + 1));
			}

			if (null != temp.right) {
				queue.add(temp.right);
				queue.add(new TreeNode(marker.val + 1));
			}

		}

		for (List<Integer> val : level.values()) {
			System.out.print("The level contains: ");
			for (Integer blah : val) {
				System.out.print(blah + ", ");
			}
			treeLevel.add(val);
		}
		return treeLevel;
	}

	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        
	        List<List<Integer>> treeLevel = new LinkedList<List<Integer>>();
	        if( null == root){
	            return treeLevel;
	        }
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	        
	        queue.add(root);
	        queue.add(new TreeNode(0));
	       
	        while( !queue.isEmpty()){
	            TreeNode temp = queue.poll();
	            int level = queue.poll().val;
	            
	            if(null == map.get(level)){
	                map.put(level, new ArrayList<Integer>());
	            }
	            
	            map.get(level).add(temp.val);
	            
	            if(null != temp.left){
	                queue.add(temp.left);
	                queue.add(new TreeNode(level+1));
	            }
	            
	             if(null != temp.right){
	                queue.add(temp.right);
	                queue.add(new TreeNode(level+1));
	            }
	        }
	        
	        for( ArrayList<Integer> list : map.values()){
	            ((LinkedList<List<Integer>>) treeLevel).addFirst(list);
	        }
	        
	        return treeLevel;
	        
	    }
	
	
}
