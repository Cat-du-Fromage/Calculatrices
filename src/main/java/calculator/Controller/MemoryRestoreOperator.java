package calculator.Controller;

import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération de restauration de la valeur stockée dans la mémoire.
 * Hérite de {@link Operator}.
 */
public class MemoryRestoreOperator extends Operator {

    /**
     * Constructeur pour initialiser l'opération de restauration de mémoire avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public MemoryRestoreOperator(State state) {
        super(state);
    }

    /**
     * Exécute l'opération de restauration.
     * Affiche la valeur stockée en mémoire sur l'écran de la calculatrice.
     */
    @Override
    public void execute() {
        state.displayStore();
    }
}
