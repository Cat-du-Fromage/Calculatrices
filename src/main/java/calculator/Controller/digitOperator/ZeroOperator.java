package calculator.Controller.digitOperator;

import calculator.State;

/**
 * Représente l'opérateur pour l'ajout d'un zéro à l'affichage.
 */
public class ZeroOperator extends DigitOperator {
    /**
     * Initialise l'opérateur avec un état et le caractère '0' pour le zéro.
     * @param state l'état courant de la calculatrice.
     */
    public ZeroOperator(State state) {
        super(state, '0');
    }

    /**
     * Vérifie si un zéro est ajouté inutilement en début de valeur non décimale.
     * @return true si un zéro est présent en début de valeur non valide, sinon false.
     */
    private boolean hasZeroTrail() {
        return state.digitsLength() < 2 && state.lastInput() == '0' && !state.isDecimalValue();
    }

    /**
     * Redéfinition: Vérifie les conditions avant d'ajouter le zéro.
     * @return true si l'ajout est valide, sinon false.
     */
    @Override
    protected boolean checkBeforeCommit() {
        return super.checkBeforeCommit() && !hasZeroTrail();
    }

}
