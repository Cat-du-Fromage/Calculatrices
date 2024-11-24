package calculator.Controller.digitOperator;

import calculator.State;

/**
 * Représente une opération pour ajouter un point décimal à l'affichage.
 */
public class PointOperator extends DigitOperator {
    /**
     * Initialise l'opérateur avec un état et le caractère '.' pour le point décimal.
     * @param state l'état courant de la calculatrice.
     */
    public PointOperator(State state) {
        super(state, '.');
    }

    /**
     * Redéfinition: Ajoute un zéro avant le point si l'affichage est vide, puis ajoute le point.
     */
    @Override
    protected void commitDigit() {
        if (state.isDigitEmpty()) {
            state.commitDigit('0');
        }
        super.commitDigit();
    }
}
