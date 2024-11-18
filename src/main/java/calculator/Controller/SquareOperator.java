package calculator.Controller;

import calculator.Operator;
import calculator.State;

public class SquareOperator extends Operator
{
    public SquareOperator(State state)
    {
        super(state);
    }

    @Override
    public void execute()
    {
        if(state.checkSyntaxError()) return;
        Double op = Double.parseDouble(state.getCurrentDisplay());
        Double result = op * op;
        state.setIntermediateValue(String.valueOf(result));
    }
}
