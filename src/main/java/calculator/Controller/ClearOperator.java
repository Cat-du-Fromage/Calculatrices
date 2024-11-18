package calculator.Controller;

import calculator.State;

public class ClearOperator extends ClearErrorOperator
{
    public ClearOperator(State state) {
        super(state);
    }

    @Override
    public void execute()
    {
        super.execute();
        state.resetStack();
    }
}
