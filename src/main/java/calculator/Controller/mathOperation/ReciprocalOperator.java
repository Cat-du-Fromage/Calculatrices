package calculator.Controller.mathOperation;
import calculator.State;

/**
 * Représente l'opération d'inversion (1/x) dans la calculatrice.
 * Hérite de {@link DivideOperator}.
 */
public class ReciprocalOperator extends DivideOperator {

    /**
     * Constructeur pour initialiser l'opérande 1/x.
     * @param state l'état de la calculatrice
     */
    public ReciprocalOperator(State state) {
        super(state);
    }

    /**
     * Calcule l'inverse de l'opérande affiché (1/x).
     * @return l'inverse de la valeur affichée
     */
    @Override
    protected Double calculate() {
        return 1 / getDisplayOperand();
    }
}
