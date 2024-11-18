package calculator.Controller;

import calculator.Operator;
import calculator.State;

public class ClearErrorOperator extends Operator
{
    public ClearErrorOperator(State state)
    {
        super(state);
    }

    @Override
    public void execute()
    {
        state.resetDisplay();
    }
}

