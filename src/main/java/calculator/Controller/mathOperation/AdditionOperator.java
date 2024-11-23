package calculator.Controller.mathOperation;
import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération d'addition dans la calculatrice.
 * Hérite de {@link MathOperator}.
 */
public class AdditionOperator extends MathOperator {

    /**
     * Constructeur pour initialiser l'addition avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public AdditionOperator(State state) {
        super(state);
    }

    /**
     * Effectue l'addition entre les opérandes.
     * @return le résultat de l'addition
     */
    @Override
    protected Double calculate() {
        return getStackOperand() + getDisplayOperand();
    }
}
