package calculator.Controller.mathOperation;

import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération de mise au carré dans la calculatrice.
 * Hérite de {@link MathOperator}.
 */
public class SquareOperator extends MathOperator {

    /**
     * Constructeur pour initialiser l'opération de mise au carré avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public SquareOperator(State state) {
        super(state);
    }

    /**
     * Effectue le calcul du carré de l'opérande.
     * @return le résultat du carré de l'opérande
     */
    @Override
    protected Double calculate() {
        Double op = getDisplayOperand();
        return op * op;
    }
}
