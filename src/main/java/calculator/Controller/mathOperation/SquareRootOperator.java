package calculator.Controller.mathOperation;

import calculator.EErrorType;
import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération de racine carrée dans la calculatrice.
 * Hérite de {@link MathOperator}.
 */
public class SquareRootOperator extends MathOperator {

    /**
     * Constructeur pour initialiser la racine carrée avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public SquareRootOperator(State state) {
        super(state);
    }

    /**
     * Vérifie si l'opérande est hors du domaine pour la racine carrée (valeur négative).
     * @return {@code true} si l'opérande est négatif, sinon {@code false}
     */
    private boolean isOutOfDomain() {
        boolean isNegative = state.isNegative();
        if(isNegative) {
            state.setErrorType(EErrorType.DOMAIN_ERROR);
        }
        return isNegative;
    }

    /**
     * Redéfinition pour y ajouter l'erreur lié au domaine de définition
     * @return {@code true} en cas d'erreur, sinon {@code false}
     */
    @Override
    protected boolean hasError() {
        return super.hasError() || isOutOfDomain();
    }

    /**
     * Effectue le calcul de la racine carrée de l'opérande.
     * @return le résultat de la racine carrée
     */
    @Override
    protected Double calculate() {
        return Math.sqrt(getDisplayOperand());
    }
}
