package Opdracht1;

public class TreeNode {
	protected TreeNode left = new TreeNode();
	protected TreeNode right = new TreeNode();
	TreeNode(){
		
	}
	
	public TreeNode getLeft(){
		return this.left;
	}
	
	public TreeNode getRight(){
		return this.right;
	}
}