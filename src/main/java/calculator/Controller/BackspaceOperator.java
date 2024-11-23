package calculator.Controller;

import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération de suppression du dernier chiffre (Backspace) dans la calculatrice.
 * Hérite de {@link Operator}.
 */
public class BackspaceOperator extends Operator {
    /**
     * Constructeur pour initialiser l'opération de suppression avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public BackspaceOperator(State state) {
        super(state);
    }

    /**
     * Exécute l'opération de suppression.
     * Supprime le dernier chiffre si aucune erreur n'est affichée, que les chiffres ne sont pas vides
     * et qu'il ne s'agit pas d'une valeur intermédiaire.
     */
    @Override
    public void execute() {
        if(state.isErrorDisplayed() || state.isDigitEmpty() || state.isIntermediateValue()) return;
        state.removeLastDigit();
        state.updateDisplay();
    }
}
