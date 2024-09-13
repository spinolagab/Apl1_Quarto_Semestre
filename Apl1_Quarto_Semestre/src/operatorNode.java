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
                return leftValue / rightValue; 
        }
         return 0;
    }
}
