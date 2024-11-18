package calculator.Controller;
import calculator.Operator;
import calculator.State;

public class SignOperator extends Operator
{
    private Character operator = '-';
    public SignOperator(State state)
    {
        super(state);
    }

    @Override
    public void execute()
    {
        state.toggleNegative();
    }
}
