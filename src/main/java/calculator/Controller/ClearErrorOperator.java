package calculator.Controller;

import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération de suppression de l'erreur affichée (Clear Error) dans la calculatrice.
 * Hérite de {@link Operator}.
 */
public class ClearErrorOperator extends Operator {
    /**
     * Constructeur pour initialiser l'opération de suppression d'erreur avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public ClearErrorOperator(State state) {
        super(state);
    }

    /**
     * Exécute l'opération de suppression d'erreur.
     * Réinitialise l'affichage de la calculatrice en supprimant les erreurs affichées.
     */
    @Override
    public void execute() {
        state.resetDisplay();
    }
}

