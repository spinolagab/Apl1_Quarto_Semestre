/*
 *	Gabriel Alves de Freitas Spinola Sucupira - 10418133
 * Enzo Benedetto Proença - 10418579
 */

public class BinaryNode {
	// valor ("chave" do nó)
	protected String key;

	// referência para o nó do pai
	protected BinaryNode parent;

	// referências para filho da esquerda e filho da direita
	protected BinaryNode left;
	protected BinaryNode right;

	// Construtores

	public BinaryNode() {
		this.key = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public BinaryNode(String key) {
		this.key = key;
	}

	public BinaryNode(String key, BinaryNode parent) {
		this.key = key;
		this.parent = parent;
		this.left = null;
		this.right = null;
	}

	public BinaryNode(String key, BinaryNode parent, BinaryNode left) {
		this.key = key;
		this.parent = parent;
		this.left = left;
		this.right = null;
	}

	public BinaryNode(String key, BinaryNode parent, BinaryNode left, BinaryNode right) {
		this.key = key;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	public boolean isRoot() {
		return parent == null;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	// Getters

	public BinaryNode getRight() {
		return right;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public String getKey() {
		return key;
	}

	public BinaryNode getParent() {
		return parent;
	}

	public int getDegree() {
		int degree = 0;

		if (left != null)
			degree++;
		if (right != null)
			degree++;
		return degree;
	}

	public int getLevel() {
		if (isRoot())
			return 0;

		return parent.getLevel() + 1;
	}

	public int getHeight() {
		if (isLeaf())
			return 0;

		return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight());
	}

	// Setters

	public void setKey(String key) {
		this.key = key;
	}

	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}

	public void setRight(BinaryNode right) {
		this.right = right;

		if (this.right != null) {
			this.right.setParent(this);
		}
	}

	public void setLeft(BinaryNode left) {
		this.left = left;

		if (this.left != null) {
			this.left.setParent(this);
		}
	}

	public float visit() {
		return Float.NaN;
	}
}