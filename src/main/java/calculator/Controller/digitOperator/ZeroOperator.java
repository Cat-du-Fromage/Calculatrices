package calculator.Controller.digitOperator;
import calculator.State;

public class ZeroOperator extends DigitOperator
{
    public ZeroOperator(State state)
    {
        super(state, '0');
    }

    /**
     * Vérifie que on ne met pas une suite de zéro avant un chiffre
     * @return suite de 0
     */
    private boolean hasZeroTrail()
    {
        return state.digitsLength() < 2 && state.lastInput() == '0' && !state.isDecimalValue();
    }

    @Override
    protected boolean checkBeforeCommit()
    {
        return super.checkBeforeCommit() && !hasZeroTrail();
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
        //empêche une suite de zéro avant la virgule
        if(hasZeroTrail()) return;
        state.commitDigit(value);
        state.updateDisplay();
    }
    */

}
