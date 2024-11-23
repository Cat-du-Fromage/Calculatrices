package calculator.Controller.digitOperator;
import calculator.State;

public class NumberOperator extends DigitOperator
{
    //protected Character value;
    public NumberOperator(State state, int value)
    {
        super(state, (char) (value + '0'));
        //this.value = (char) (value + '0');
    }
    /*
    @Override
    public void execute()
    {
        if(state.isErrorDisplayed()) return;
        if(state.isIntermediateValue())
        {
            state.addToStack();
        }

        state.commitDigit(value);
        state.updateDisplay();
    }
    */
}
