package calculator.Controller;

import calculator.Operator;
import calculator.State;

public class StoreOperator extends Operator
{
    public StoreOperator(State state)
    {
        super(state);
    }

    @Override
    public void execute()
    {
        state.storeValue();
    }
}
