package calculator.Controller.mathOperation;

import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération de multiplication dans la calculatrice.
 * Hérite de {@link MathOperator}.
 */
public class ProductOperator extends MathOperator {
    /**
     * Constructeur pour initialiser la multiplication avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public ProductOperator(State state) {
        super(state);
    }

    /**
     * Effectue le calcul de la multiplication entre les opérandes.
     * @return le résultat de la multiplication
     */
    @Override
    protected Double calculate() {
        return getStackOperand() * getDisplayOperand();
    }
}
