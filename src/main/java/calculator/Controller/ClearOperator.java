package calculator.Controller;

import calculator.State;

/**
 * Représente l'opération de réinitialisation complète (Clear) dans la calculatrice.
 * Hérite de {@link ClearErrorOperator}.
 */
public class ClearOperator extends ClearErrorOperator {
    /**
     * Constructeur pour initialiser l'opération de réinitialisation complète avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public ClearOperator(State state) {
        super(state);
    }

    /**
     * Exécute l'opération de réinitialisation complète.
     * Supprime l'erreur affichée, réinitialise la pile et efface la mémoire stockée.
     */
    @Override
    public void execute() {
        super.execute();
        state.resetStack();
        state.clearMemoryStore();
    }
}
