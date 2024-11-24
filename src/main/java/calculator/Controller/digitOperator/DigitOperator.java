package calculator.Controller.digitOperator;

import calculator.Operator;
import calculator.State;

/**
 * Représente une opération liée à l'ajout d'un chiffre à l'état actuel.
 * Permet d'ajouter un chiffre ou un point décimal à l'affichage.
 */
public class DigitOperator extends Operator {
    /**
     * Chiffre ou caractère à ajouter.
     */
    protected Character value;

    /**
     * Initialise l'opérateur avec un état et une valeur donnée.
     *
     * @param state l'état courant de la calculatrice.
     * @param value le caractère à ajouter.
     */
    protected DigitOperator(State state, char value) {
        super(state);
        this.value = value;
    }

    /**
     * Vérifie si l'ajout d'un chiffre est valide avant de le valider.
     * Ajoute les valeurs intermédiaires à la pile si nécessaire.
     *
     * @return true si l'ajout peut être effectué, false sinon.
     */
    protected boolean checkBeforeCommit() {
        if (state.isErrorDisplayed()) return false;
        if (state.isIntermediateValue()) {
            state.addToStack();
        }
        return true;
    }

    /**
     * Ajoute le caractère représenté par l'opérateur à l'affichage.
     */
    protected void commitDigit() {
        state.commitDigit(value);
        state.updateDisplay();
    }

    /**
     * Exécute l'opération en vérifiant les conditions avant de valider l'ajout.
     * Ne fait rien si les conditions de validation échouent.
     */
    @Override
    public void execute() {
        if (!checkBeforeCommit()) return;
        commitDigit();
    }
}
