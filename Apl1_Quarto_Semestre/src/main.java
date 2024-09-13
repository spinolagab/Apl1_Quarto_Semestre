import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

  public static boolean isOperator(char c) {
    if (String.valueOf(c).matches("[-+*/]"))
      return true;

    return false;
  }

  public static void Main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String choice = "";
    
    BinaryTree Arvore = null;
    
    do {
    // Decidir se o menu deve aparecer várias vezes.
      System.out.println("1.Entrada da expressão aritmética na notação infixa.\n");
      System.out.println("2.Criação da árvore binária de expressão aritmética.\n");
      System.out.println("3.Exibição da árvore binária de expressão aritmética.\n");
      System.out.println("4.Cálculo da expressão\n");
      System.out.println("5.Encerramento do programa.\n");
      System.out.println("Informe o número de sua escolha: ");
      choice = scanner.nextLine();

      switch (choice) {
        case "1":
          try {
            System.out.println("Informe a expressão infixa: \n");
            String input = scanner.nextLine();
            input = input.replaceAll("\\s+", "");

            for (int i = 0; i < input.length(); i++) {
              char elem1 = input.charAt(i);
              if (Character.isLetter(elem1))
               throw new InputMismatchException("Entrada inválida. Somente números e operadores são aceitos");

              if (isOperator(elem1)) {
                char elem2 = (i + 1 < input.length()) ? input.charAt(i + 1) : '\0';
                if (isOperator(elem2))
                  throw new IllegalArgumentException("Entrada inválida. Duplo operador detectado.");
              }
            }
            choice = "";
          } catch (Exception e) {
            System.out.println(e);
          }
          break;
          
        case "2":
        	break;
        	
        case "3":
    	  if(Arvore.isEmpty()) {
    		  System.out.println("A árvore ainda não foi criada ou está vazia!");
    	  }else {
    		  System.out.println("Pré ordem: ");
    		  Arvore.preOrderTraversal();
    		  System.out.println("Em ordem: ");
    		  Arvore.inOrderTraversal();
    		  System.out.println("Pós ordem: ");
    		  Arvore.postOrderTraversal();
    	  }
    	  break;
    	  
        case "4":
    	  //TODO: dados da função 4
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