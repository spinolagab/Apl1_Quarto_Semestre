import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

  public static boolean isOperator(char c){
      return c == '+' || c == '-' || c == '*' || c == '/';
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String choice = "";

    BinaryTree Arvore = new BinaryTree();

    String input = "";
    do {
      System.out.println(new String(new char[55]).replace("\0", "="));
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

            for (int i = 0; i < input.length(); i++) {
              char elem1 = input.charAt(i);
              if (Character.isLetter(elem1)) {
                input = "";
                throw new InputMismatchException("Entrada inválida. Somente números e operadores são aceitos");
              }

              if (isOperator(elem1)) {
                char elem2 = (i + 1 < input.length()) ? input.charAt(i + 1) : '\0';
                if (isOperator(elem2)) {
                  input = "";
                  throw new IllegalArgumentException("Entrada inválida. Duplo operador detectado.");
                }
              }
            }
            System.out.println("Expressão infixa aceita.");
            choice = "";
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;

        case "2":
          // Criação da Árvore binária
          try {
           BinaryNode root = Arvore.buildTree(input);
           Arvore.setRoot(root);
           System.out.println("Árvore criada com sucesso.");
 
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;

        case "3":
          if (Arvore.isEmpty()) {
            System.out.println("A árvore ainda não foi criada ou está vazia!");
          } else {
            System.out.println("Pré ordem: ");
            Arvore.preOrderTraversal();
            System.out.println("Em ordem: ");
            Arvore.inOrderTraversal();
            System.out.println("Pós ordem: ");
            Arvore.postOrderTraversal();
          }
          break;

        case "4":
          // TODO: Calcular a expressão na árvore
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
