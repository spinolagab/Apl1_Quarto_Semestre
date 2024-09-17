/*
 * Gabriel Alves de Freitas Spinola Sucupira - 10418133
 * Enzo Benedetto Proença - 10418579
 */

import java.util.Stack;
import java.util.InputMismatchException;

public class BinaryTree {
	private BinaryNode root;

	// Construtores
	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(BinaryNode root) {
		this.root = root;
	}

	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode node) {
		this.root = node;
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
		if (root != null) {
			inOrderTraversal(root.getLeft());
			System.out.print(root.getKey() + "  ");
			inOrderTraversal(root.getRight());
		}
	}

	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	private void preOrderTraversal(BinaryNode root) {
		if(root != null) {
		
			System.out.print(root.getKey() + "  ");
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		
		}
	}

	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	private void postOrderTraversal(BinaryNode root) {
		if(root != null) {
			
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.print(root.getKey() + "  ");
			
		}
	}

	private int precedence(char operator) {
		switch (operator) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
		}
		return -1;
	}

	private operatorNode createSubTree(char operator, BinaryNode right, BinaryNode left) {
		operatorNode node = new operatorNode();
		node.setKey(String.valueOf(operator));
		node.setLeft(left);
		node.setRight(right);
		return node;
	}

	public BinaryNode buildTree(String expression) {
		Stack<BinaryNode> nodes = new Stack<>();
		Stack<Character> operators = new Stack<>();
		boolean hasDecimal;
		for (int i = 0; i < expression.length(); i++) {
			char current = expression.charAt(i);

			// Caso seja operando
			if (Character.isDigit(current)) {
				StringBuilder operand = new StringBuilder();
				
				// Coleta o número. 
				hasDecimal = false;
				while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')){
					if (expression.charAt(i) == '.'){
						if (hasDecimal)
							throw new InputMismatchException("Entrada inválida. Um número não pode ter dois marcadores de decimal");

						hasDecimal = true;
					}

					operand.append(expression.charAt(i++));
				}
				i--;

				operandNode operandNode = new operandNode();
				operandNode.setKey(operand.toString());
				nodes.push(operandNode);
			} else if (current == '(') {
				operators.push(current);
			} else if (current == ')') {
				while (operators.peek() != '(') {
					nodes.push(createSubTree(operators.pop(), nodes.pop(), nodes.pop()));
				}
				// Remove o '(' da pilha
				operators.pop();
			} else if (main.isOperator(current)) {
				while (!operators.isEmpty() && precedence(current) <= precedence(operators.peek()))
					nodes.push(createSubTree(operators.pop(), nodes.pop(), nodes.pop()));
				operators.push(current);

			}

		}
		while (!operators.isEmpty())
			nodes.push(createSubTree(operators.pop(), nodes.pop(), nodes.pop()));

		return nodes.pop();
	}

	public float calculateExpressionTree(){
		return root.visit();
	}
}
