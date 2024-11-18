package calculator.Controller;
import calculator.EErrorType;
import calculator.Operator;
import calculator.State;

public class EnterOperator extends Operator
{
    public EnterOperator(State state)
    {
        super(state);
    }

    @Override
    public void execute()
    {
        state.addToStack();
    }
}
