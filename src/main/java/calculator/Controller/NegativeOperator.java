package calculator.Controller;
import calculator.Operator;
import calculator.State;

public class NegativeOperator extends DivideOperator
{
    public NegativeOperator(State state)
    {
        super(state);
    }

    @Override
    public void execute()
    {
        if(state.checkSyntaxError() || isDivisionByZero()) return;
        Double result = 1 / Double.parseDouble(state.getCurrentDisplay());
        state.setIntermediateValue(String.valueOf(result));
    }
}
