package calculator.Controller;

import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération de stockage de valeur dans la calculatrice.
 * Hérite de {@link Operator}.
 */
public class StoreOperator extends Operator {
    /**
     * Constructeur pour initialiser l'opération de stockage avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public StoreOperator(State state) {
        super(state);
    }

    /**
     * Exécute l'opération de stockage.
     * Stocke la valeur courante dans la mémoire de la calculatrice.
     */
    @Override
    public void execute() {
        state.storeValue();
    }
}
