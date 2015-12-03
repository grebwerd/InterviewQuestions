package binaryTreeFindLowestCommonAncestor;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode level1La = new TreeNode(5);
		TreeNode level1Ra = new TreeNode(1);
		TreeNode level2La = new TreeNode(6);
		TreeNode level2Lb = new TreeNode(2);
		TreeNode level2Ra = new TreeNode(0);
		TreeNode level2Rb = new TreeNode(8);
		TreeNode level3La = new TreeNode(7);
		TreeNode level3Lb = new TreeNode(4);

		root.left = level1La;
		root.right = level1Ra;

		level1La.left = level2La;
		level1La.right = level2Lb;

		level1Ra.left = level2Ra;
		level1Ra.right = level2Rb;

		level2Lb.left = level3La;
		level2Lb.right = level3Lb;
		Main m = new Main();
		m.lowestCommonAncestor(root, level1La, level3Lb);

	}
	
	public Map<TreeNode, TreeNode> getNodeParent(TreeNode root){
		Map<TreeNode, TreeNode> map = new HashMap<>();
		if(null == root){
			return map;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		map.put(root, null);
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			
			if(temp.left != null){
				stack.push(temp.left);
				map.put(temp.left, temp);
			}
			
			if(temp.right != null){
				stack.push(temp.right);
				map.put(temp.right, temp);
			}
		}
		return map;
	}

	
	
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (null == root) {
			return null;
		}

		if (p == q) {
			return p;
		}
		Map<TreeNode, TreeNode> map = getNodeParent(root);
		Stack<TreeNode> pPath = getPathFromRoot(p, map);
		
		System.out.println();
		
		
		System.out.println();
		Stack<TreeNode> qPath = getPathFromRoot(q, map);
		
		System.out.println();
		
		return findAncestor(pPath, qPath);

	}
	
	
	public Stack<TreeNode> getPathFromRoot(TreeNode node, Map<TreeNode, TreeNode> map){
		if(null == node){
			return null;
		}
		
		Stack<TreeNode> path = new Stack<>();
		//System.out.print("Getting reverse path from node " + node.val + " to the root: ");
		path.push(node);
		
		while(null != map.get(node)){
			TreeNode temp = map.get(node);
			//System.out.print(node.val + ",");
			path.push(temp);
			node = temp;
		}
		return path;
	}
	
	public TreeNode findAncestor(Stack<TreeNode> pPath, Stack<TreeNode> qPath) {
		int length = Integer.min(pPath.size(), qPath.size());
		TreeNode commonAncestor = null;
		//System.out.println("the size of length is " + length);
		for (int i = 0; i < length; i++) {

			TreeNode pTemp = pPath.pop();
			TreeNode qTemp = qPath.pop();

			//System.out.println("pTemp : " + pTemp.val + ", qTemp.val : " + qTemp.val);
			if (pTemp == qTemp) {
				commonAncestor = pTemp;
				continue;
			} else {
				break;
			}
		}
		//System.out.println("The common ancestor is " + commonAncestor.val);
		return commonAncestor;

	}
	
	
	public TreeNode getLCA(TreeNode curr, TreeNode A, TreeNode B ){
		if( null == curr){
			return null;
		}
		
		if( curr == A || curr == B){
			return curr;
		}
		
		TreeNode left = getLCA(curr.left, A, B);
		TreeNode right = getLCA(curr.right, A, B);
		
		
		//If this condition is true, then the LCA has been found
		if( null != left && null != right){
			return curr;
		}
		
		if(null == left){
			return right;
		}else{
			return left;
		}
	}

}
