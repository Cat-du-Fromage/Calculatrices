package calculator.Controller.mathOperation;
import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération de soustraction dans la calculatrice.
 * Hérite de {@link MathOperator}.
 */
public class SubtractOperator extends MathOperator {

    /**
     * Constructeur pour initialiser la soustraction avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public SubtractOperator(State state) {
        super(state);
    }

    /**
     * Effectue la soustraction entre les opérandes.
     * @return le résultat de la soustraction
     */
    @Override
    protected Double calculate() {
        return getStackOperand() - getDisplayOperand();
    }
}
