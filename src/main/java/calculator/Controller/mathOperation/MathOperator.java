package calculator.Controller.mathOperation;
import calculator.Operator;
import calculator.State;

/**
 * Classe abstraite représentant une opération mathématique étend {@link Operator}.
 */
public abstract class MathOperator extends Operator {

    /**
     * Constructeur de MathOperator.
     * @param state l'état actuel de la calculatrice, partagé entre les opérations
     */
    protected MathOperator(State state) {
        super(state);
    }

    /**
     * Vérifie s'il existe une erreur de syntaxe dans l'état actuel.
     * @return {@code true} si une erreur de syntaxe est détectée, {@code false} sinon
     */
    protected boolean hasError() {
        return state.checkSyntaxError();
    }

    /**
     * Récupère et retire la valeur située en haut de la pile en tant qu'opérande pour l'opération.
     * @return la valeur située en haut de la pile sous forme de {@link Double},ou 0 si la pile est vide
     */
    protected Double getStackOperand() {
        return state.popStack();
    }

    /**
     * Récupère la valeur actuellement affichée sur la calculatrice en tant qu'opérande.
     * @return la valeur affichée sur la calculatrice sous forme de {@link Double}
     */
    protected Double getDisplayOperand() {
        return state.getCurrentDisplayValue();
    }


    /**
     * Méthode abstraite qui définit la logique de calcul pour l'opération mathématique.
     * @return le résultat du calcul sous forme de {@link Double}
     */
    protected abstract Double calculate();

    /**
     * Exécute l'opération mathématique.
     * Vérifie avant si il n'y a pas d'erreurs
     */
    @Override
    public final void execute() {
        if(hasError()) return;
        state.setIntermediateValue(String.valueOf(calculate()));
    }
}
