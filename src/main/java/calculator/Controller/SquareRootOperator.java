package calculator.Controller;

import calculator.EErrorType;
import calculator.Operator;
import calculator.State;

public class SquareRootOperator extends Operator
{
    public SquareRootOperator(State state)
    {
        super(state);
    }

    protected boolean isOutOfDomain()
    {
        if(state.isNegativ())
        {
            state.setErrorType(EErrorType.DOMAIN_ERROR);
        }
        return state.isNegativ();
    }

    @Override
    public void execute()
    {
        if(state.checkSyntaxError() || isOutOfDomain()) return;
        Double result = Math.sqrt(Double.parseDouble(state.getCurrentDisplay()));
        state.setIntermediateValue(String.valueOf(result));
    }
}
