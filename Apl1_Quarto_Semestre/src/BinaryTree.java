/*
 Gabriel Alves de Freitas Spinola Sucupira - 10418133
 Enzo Benedetto Proença - 10418579
 */

public class BinaryTree {
	private BinaryNode root;
	
	public BinaryNode getRoot() {
		return root;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int getDegree() {
		if (isEmpty()) {
			return -1;
		}
		return Math.max(root.getLeft() == null ? 0 : root.getLeft().getDegree(), 
				root.getRight() == null ? 0 : root.getRight().getDegree());
	}
	
	public int getHeight() {
		if (isEmpty()) 
			return -1;
		
		
		return root.getHeight();
	}
	
	
	
	// Print nas ordens gerais da árvore
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(BinaryNode root) {
		if(root != null) {
			inOrderTraversal(root.getLeft());
			System.out.println(root.getKey());
			inOrderTraversal(root.getRight());
		}
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}
	
	private void preOrderTraversal(BinaryNode root) {
		System.out.println(root.getKey());
		inOrderTraversal(root.getLeft());
		inOrderTraversal(root.getRight());
	}
	
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}
	
	private void postOrderTraversal(BinaryNode root) {
		inOrderTraversal(root.getLeft());
		inOrderTraversal(root.getRight());
		System.out.println(root.getKey());
	}
}
