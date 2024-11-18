package calculator.Controller;
import calculator.Operator;
import calculator.State;

public class AdditionOperator extends Operator
{
    public AdditionOperator(State state)
    {
        super(state);
    }

    @Override
    public void execute()
    {
        if(state.checkSyntaxError()) return;
        //par du principe que si la pile est vide on prend 0
        Double op1 = state.getStack().isEmpty() ? 0.0 : Double.parseDouble(state.getStack().pop());
        Double op2 = Double.parseDouble(state.getCurrentDisplay());
        Double result = op1 + op2;

        state.setIntermediateValue(String.valueOf(result));
    }
}
