import java.util.Scanner;

public class main {
  public static validateInput(String input){
    return input.matches("[0-9\\+-*/().\\]+");
  }

	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    // Decidir se o menur deve aparecer várias vezes.
    System.out.println("1.\n");
    System.out.println("2.\n");
    System.out.println("3.\n");
    System.out.println("4.\n");
    System.out.println("5.\n");
    System.out.println("Informe o número de sua escolha: ");
    scanner.nextLine();

    while (true) {
      switch (scanner) {
        case "1":
          try {

            System.out.println("Informe a expressão infixa: \n");
            scanner.nextLine();

            if (validateInput(scanner)){
              System.out.println("Entrada válida.\n");
            } else {
                System.out.println("Entrada inválida. Use somente número (inteiros ou decimais), operadores matemáticos (+, *, -, /) e parênteses.");
                throw new InputMismatchException("Entrada inválida.") 
              }

          } catch (Exception e) {
            System.out.println("Deu erro patrão.");
          }
          break;
        default:
          System.out.println("Escolha inválida.");
          break;
      }
    }

	}

}
