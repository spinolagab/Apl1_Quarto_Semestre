/*
 *	Gabriel Alves de Freitas Spinola Sucupira - 10418133
 * Enzo Benedetto Proença - 10418579
 */
public class operatorNode extends BinaryNode{
    @Override
    public float visit(){
        float leftValue = left.visit();
        float rightValue = right.visit();

        switch (key) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                if (rightValue == 0)
                    throw new ArithmeticException("Operação inválida. Divisão por zero.");
                return leftValue / rightValue; 
        }
         return 0;
    }
}
