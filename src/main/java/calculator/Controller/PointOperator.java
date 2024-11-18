package calculator.Controller;
import calculator.Operator;
import calculator.State;

public class PointOperator extends Operator
{
    private Character operator = '.';
    public PointOperator(State state)
    {
        super(state);
    }

    @Override
    public void execute()
    {
        state.commitDigit(operator);
    }
}
