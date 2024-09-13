public class operandNode extends BinaryNode {
    @Override
    public float visit(){
        return Float.parseFloat(key);
    }
}