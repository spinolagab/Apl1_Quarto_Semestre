import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Decidir se o menu deve aparecer várias vezes.
    System.out.println("1.Entrada da expressão aritmética na notação infixa.\n");
    System.out.println("2.Criação da árvore binária de expressão aritmética.\n");
    System.out.println("3.Exibição da árvore binária de expressão aritmética.\n");
    System.out.println("4.Cálculo da expressão\n");
    System.out.println("5.Encerramento do programa.\n");
    System.out.println("Informe o número de sua escolha: ");
    String choice = scanner.nextLine();

    /*
     * System.out.
     * println("Entrada inválida. Use somente número (inteiros ou decimais), operadores matemáticos (+, *, -, /) e parênteses."
     * );
     *
     * 
     * 
     */
    switch (choice) {
      case "1":
        try {
          System.out.println("Informe a expressão infixa: \n");
          // Validação de entrada, usando regex (Regular expression) 
          // Todo: Validador de paridade de parênteses. Ideia, usar pilha pra isso. 
          String input = scanner.nextLine();
          input = input.replaceAll("\\s+", "");

          String regex = "(-?\\d*\\.?\\d+|[+\\-*/])";
          java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
          java.util.regex.Matcher matcher = pattern.matcher(input);

          while (matcher.find()) {
            String token = matcher.group();

            // Check if the token is a number or an operator
            if (token.matches("-?\\d*\\.?\\d+")) {
              // It's a number
              System.out.println("Number: " + token);
            } else if (token.matches("[+\\-*/]")) {
              // It's an operator
              System.out.println("Operator: " + token);
            }
          }
        } catch (Exception e) {
          System.out.println(e);
        }
        break;
      case "5":
        System.out.println("Saindo...");
        scanner.close();
        System.exit(0);
        break;
      default:
        System.out.println("Escolha inválida.");
        scanner.close();
        break;
    }

  }
}