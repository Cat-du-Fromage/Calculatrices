package calculator.Controller;

import calculator.Operator;
import calculator.State;

public class BackspaceOperator extends Operator
{
    public BackspaceOperator(State state) {
        super(state);
    }
    //Test
    //TODO Doit mettre en stack si intermediaire?
    @Override
    public void execute()
    {
        if(state.isErrorDisplayed() || state.getDigits().isEmpty()) return;
        state.getDigits().removeLast();
        state.setCurrentDisplay();
    }
}
