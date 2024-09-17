/*
 *	Gabriel Alves de Freitas Spinola Sucupira - 10418133
 * Enzo Benedetto Proença - 10418579
 */
public class operandNode extends BinaryNode {
    @Override
    public float visit(){
        return Float.parseFloat(key);
    }
}