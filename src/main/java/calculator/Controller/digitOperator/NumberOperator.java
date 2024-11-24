package calculator.Controller.digitOperator;

import calculator.State;

/**
 * Représente une opération pour ajouter un chiffre numérique à l'affichage.
 */
public class NumberOperator extends DigitOperator {
    /**
     * Initialise l'opérateur avec un état et une valeur entière.
     *
     * @param state l'état courant de la calculatrice.
     * @param value l'entier à ajouter à l'affichage (entre 0 et 9 inclus).
     */
    public NumberOperator(State state, int value) {
        super(state, (char) (value + '0'));
    }
}
