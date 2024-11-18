package calculator.Controller;

import calculator.EErrorType;
import calculator.Operator;
import calculator.State;

public class DivideOperator extends Operator
{
    public DivideOperator(State state)
    {
        super(state);
    }

    protected boolean isDivisionByZero()
    {
        String currentDisplay = state.getCurrentDisplay();
        boolean isDivisionByZero = currentDisplay.isEmpty() || Double.parseDouble(currentDisplay) == 0.0;
        if(isDivisionByZero)
        {
            state.setErrorType(EErrorType.DIVIDE_BY_ZERO);
        }
        return isDivisionByZero;
    }

    @Override
    public void execute()
    {
        if(state.checkSyntaxError() || isDivisionByZero()) return;
        //par du principe que si la pile est vide on prend 0
        Double op1 = state.getStack().isEmpty() ? 0.0 : Double.parseDouble(state.getStack().pop());
        Double op2 = Double.parseDouble(state.getCurrentDisplay());
        Double result = op1 / op2;

        state.setIntermediateValue(String.valueOf(result));
    }
}
