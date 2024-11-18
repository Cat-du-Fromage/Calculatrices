package calculator.Controller;
import calculator.Operator;
import calculator.State;

public class NumberOperator extends Operator
{
    private Character value;

    public NumberOperator(State state, int value)
    {
        super(state);
        this.value = (char) (value + '0');
    }

    public int getValue() { return value; }

    @Override
    public void execute()
    {
        state.commitDigit(value);
    }
}
