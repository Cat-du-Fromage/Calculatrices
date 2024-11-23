package calculator.Controller.digitOperator;

import calculator.Operator;
import calculator.State;

public class DigitOperator extends Operator
{
    protected Character value;

    protected DigitOperator(State state, char value)
    {
        super(state);
        this.value = value;
    }

    protected boolean checkBeforeCommit()
    {
        if(state.isErrorDisplayed()) return false;
        if(state.isIntermediateValue())
        {
            state.addToStack();
        }
        return true;
    }

    protected void commitDigit()
    {
        state.commitDigit(value);
        state.updateDisplay();
    }

    @Override
    public void execute()
    {
        if(!checkBeforeCommit()) return;
        commitDigit();
    }
}
