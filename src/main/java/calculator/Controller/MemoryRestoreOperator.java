package calculator.Controller;

import calculator.Operator;
import calculator.State;

public class MemoryRestoreOperator extends Operator {

    public MemoryRestoreOperator(State state) {
        super(state);
    }
    //Considéré comme valeur intermédiaire?
    @Override
    public void execute() {
        state.displayStore();
    }
}
