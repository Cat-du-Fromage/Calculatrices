package calculator;

public abstract class Operator
{
    protected State state;

    protected Operator(State state)
    {
        this.state = state;
    }

    public abstract void execute();
}
