package calculator.Controller.digitOperator;
import calculator.State;

public class PointOperator extends DigitOperator
{
    //private Character operator = '.';

    public PointOperator(State state)
    {
        super(state,'.');
    }

    @Override
    protected void commitDigit()
    {
        if(state.isDigitEmpty())
        {
            state.commitDigit('0');
        }
        super.commitDigit();
    }

    /*
    @Override
    public void execute()
    {
        if(state.isErrorDisplayed()) return;
        //ajoute '0' pour éviter un '.' seul
        if(state.isIntermediateValue())
        {
            state.addToStack();
            //state.commitDigit('0');
        }

        if(state.isDigitEmpty())
        {
            state.commitDigit('0');
        }

        state.commitDigit(operator);
        state.updateDisplay();
    }
    */
}
