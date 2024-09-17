import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Stack;

public class main {

  public static boolean isOperator(char c){
      return c == '+' || c == '-' || c == '*' || c == '/';
  }
  private static boolean ParenthesisValidator(String input){
    Stack<Character> stack = new Stack<>();
    for (char c : input.toCharArray()){
      if (c == '('){
        stack.push(c);
      } else if (c == ')' ) {
        if (stack.isEmpty() || stack.pop() != '(')
          return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String choice = "";

    BinaryTree tree = new BinaryTree();

    String input = "";
    do {
      System.out.println("\n" + new String(new char[55]).replace("\0", "="));
      System.out.println("1.Entrada da expressão aritmética na notação infixa.");
      System.out.println("2.Criação da árvore binária de expressão aritmética.");
      System.out.println("3.Exibição da árvore binária de expressão aritmética.");
      System.out.println("4.Cálculo da expressão.");
      System.out.println("5.Encerramento do programa.");
      System.out.println(new String(new char[55]).replace("\0", "="));
      System.out.println("Expressão infixa atual: " + input);
      System.out.println("Informe o número de sua escolha:");
      choice = scanner.nextLine();

      switch (choice) {
        case "1":
          try {
            System.out.println("Informe a expressão infixa: ");
            input = scanner.nextLine();
            input = input.replaceAll("\\s+", "");

            // Verifica se após a entrada, o input está vazio.
            if (input.length() < 1)
              throw new Exception("Entrada inválida. Expressão infixa não pode estar vazia.");
            

            // Validar paridade de parênteses
            if (ParenthesisValidator(input) == false)
              throw new InputMismatchException("Entrada inválida. Há parênteses errados.");
            
            for (int i = 0; i < input.length(); i++) {
              char aux = input.charAt(i);
              char next = (i + 1 < input.length()) ? input.charAt(i + 1) : '\0';

              // Verifica se o operador tem dois operandos
              if (isOperator(input.charAt(0)))
                throw new InputMismatchException("Entrada inválida. Expressão não pode começar com um operador");

              if (isOperator(input.charAt(input.length()-1)))
                throw new InputMismatchException("Entrada inválida. Expressão não pode terminar com um operador.");
              
              // Permite apenas, operadores matemáticos básicos, números e parênteses.
              if (!String.valueOf(aux).matches("[.\\(\\)-+*/\\d+]")) 
                throw new InputMismatchException("Entrada inválida. Somente números e operadores (+, -, *, /) são aceitos. Use ponto para casa decimais.");
              
              // Verifica se há dois operadores em sequência.
              if (isOperator(aux) && isOperator(next)) 
                throw new IllegalArgumentException("Entrada inválida. Duplo operador detectado.");
              
              // Verifica se há um operador entre um número e uma abertura de parênteses 
              if (String.valueOf(aux).matches("\\d+") && next == '(' )
                  throw new IllegalArgumentException("Entrada inválida. Deve existir um operador entre números e parênteses de abertura.");

              // Verififca se há um operador entre o fechamento de um parênteses e um número
              if (String.valueOf(aux).matches("\\)") && String.valueOf(next).matches("\\d+"))
                throw new IllegalArgumentException("Entrada inválida. Deve existir um operador entre fechamento de parênteses e um número");

              // Verifica se há parênteses vazio.
              if (aux == '(' && next == ')')
                throw new IllegalArgumentException("Entrada inválida. Parênteses vazio.");
              
            }
            System.out.println("Expressão infixa aceita.");
            } catch (Exception e) {
              input = "";
              System.out.println(e.getMessage());
          }

          choice = "";
          break;

        case "2":
          // Criação da Árvore binária
          try {
            if (input.length() < 1)
              throw new Exception("Expressão infixa não encontrada.");
            
            BinaryNode root = tree.buildTree(input);
            tree.setRoot(root);
            System.out.println("Árvore criada com sucesso.");
 
          } catch (Exception e) {
            input = "";
            System.out.println(e.getMessage());
          }
          break;

        case "3":
          try {
            if (tree.isEmpty()) 
             throw new Exception("A árvore ainda não foi criada ou está vazia!");

            System.out.println("Pré ordem: ");
            tree.preOrderTraversal();
            
            System.out.println("\n Em ordem: ");
            tree.inOrderTraversal();
            
            System.out.println("\nPós ordem: ");
            tree.postOrderTraversal();

          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
          
          break;

        case "4":
          // Calcular a expressão na árvore
          try {
            if (tree.isEmpty())
              throw new Exception("Operação inválida. Árvore vazia ou inexistente.");

            System.out.println("Valor na árvore: " + tree.calculateExpressionTree());
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
          break;
        case "5":
          System.out.println("Saindo...");
          scanner.close();
          System.exit(0);
          break;
        default:
          System.out.println("Escolha inválida.");
          break;
      }
    } while (choice != "5");
  }
}
