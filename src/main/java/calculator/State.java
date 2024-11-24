package calculator;

//import java.util.*;
//import calculator.util.*;

import util.Stack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Représente l'état interne de la calculatrice, gérant la pile, l'affichage, les erreurs, et la mémoire.
 */
public class State {
    private Stack<String> stack = new Stack<String>();

    private ArrayList<Character> digits = new ArrayList<Character>();

    private boolean isNegative = false;

    private EErrorType errorType = EErrorType.NONE;

    private String currentDisplay = "";

    private String storedValue = "";

    private boolean isIntermediateValue = false;

    /** Constructeur */
    public State() {
        resetDisplay();
    }

//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                                ◆◆◆◆◆◆ DIGITS ◆◆◆◆◆◆                                                ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    /**
     * Retourne la valeur numérique actuellement saisie sous forme de texte.
     * @return la valeur saisie en texte.
     */
    public String getTextValue() {
        StringBuilder valueString = new StringBuilder();
        if (isNegative) valueString.append('-');
        if (digits.isEmpty()) valueString.append('0');
        for (Character digit : digits) {
            valueString.append(digit);
        }
        return valueString.toString();
    }

    /**
     * Retourne le nombre de chiffres saisis.
     * @return le nombre de chiffres.
     */
    public int digitsLength() {
        return digits.size();
    }

    /**
     * Vérifie si la valeur saisie est décimale.
     * @return true si décimale, false sinon.
     */
    public boolean isDecimalValue() {
        return digits.contains('.');
    }

    /**
     * Retourne le dernier caractère saisi.
     * @return le dernier caractère ou '0' si la liste est vide.
     */
    public char lastInput() {
        return digits.isEmpty() ? '0' : digits.getLast();
    }

    /**
     * Ajoute un chiffre ou un caractère à la saisie actuelle.
     * @param digit le caractère à ajouter.
     */
    public void commitDigit(Character digit) {
        digits.add(digit);
    }

    /**
     * Retourne si la valeur actuelle est négative.
     * @return true si négative, false sinon.
     */
    public boolean isNegative() {
        return isNegative;
    }

    /**
     * Inverse le signe de la valeur actuelle.
     */
    public void toggleSign() {
        isNegative = !isNegative;
    }

//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                          ◆◆◆◆◆◆ INTERMEDIATE VALUE ◆◆◆◆◆◆                                          ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    /**
     * Vérifie si la valeur affichée est intermédiaire.
     * @return true si intermédiaire, false sinon.
     */
    public boolean isIntermediateValue() {
        return isIntermediateValue;
    }

    /**
     * Définit une valeur intermédiaire et met à jour l'affichage.
     * @param value la valeur intermédiaire.
     */
    public void setIntermediateValue(String value) {
        digits.clear();
        for (char c : value.toCharArray()) {
            digits.add(c);
        }
        isIntermediateValue = true;
        isNegative = Double.parseDouble(value) < 0;
        updateDisplay();
    }

//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                                 ◆◆◆◆◆◆ STACK ◆◆◆◆◆◆                                                ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    //use by JCalculator!
    /**
     * Retourne la pile actuelle.
     * @return la pile des valeurs sous forme de chaîne.
     */
    public Stack<String> getStack() {
        return stack;
    }

    /**
     * Retire et retourne la valeur au sommet de la pile.
     * @return la valeur au sommet ou 0 si la pile est vide.
     */
    public Double popStack() {
        return stack.isEmpty() ? 0.0 : Double.parseDouble(stack.pop());
    }

    /**
     * Réinitialise la pile.
     */
    public void resetStack() {
        stack.clear();
    }

    /**
     * Ajoute la valeur actuelle à la pile après conversion.
     */
    public void addToStack() {
        //conversion pour supprimer les 0 inutiles après la virgule
        Double value = Double.parseDouble(getTextValue());
        stack.push(value.toString());
        isIntermediateValue = false;
        resetDisplay();
    }

    /**
     * Vérifie si la liste des chiffres est vide.
     * @return true si vide, false sinon.
     */
    public boolean isDigitEmpty() {
        return digits.isEmpty();
    }

    /**
     * Supprime le dernier chiffre saisi.
     */
    public void removeLastDigit() {
        digits.removeLast();
    }

//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                                 ◆◆◆◆◆◆ ERROR ◆◆◆◆◆◆                                                ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    /**
     * Vérifie si une erreur est affichée.
     * @return true si une erreur est affichée, false sinon.
     */
    public boolean isErrorDisplayed() {
        return Arrays.stream(EErrorType.values()).anyMatch(eErrorType -> eErrorType.name().equals(currentDisplay));
    }

    /**
     * Définit un type d'erreur et met à jour l'affichage.
     * @param type le type d'erreur.
     */
    public void setErrorType(EErrorType type) {
        errorType = type;
        if (errorType != EErrorType.NONE) {
            currentDisplay = errorType.name();
        }
    }

    /**
     * Vérifie si la syntaxe actuelle contient une erreur.
     * @return true si une erreur est détectée, false sinon.
     */
    public boolean checkSyntaxError() {
        boolean hasSyntaxError = digits.stream().filter(c -> c == '.').count() > 1;
        if (hasSyntaxError) {
            errorType = EErrorType.SYNTAX_ERROR;
            currentDisplay = EErrorType.SYNTAX_ERROR.name();
        }
        return hasSyntaxError;
    }
//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                                ◆◆◆◆◆◆ DISPLAY ◆◆◆◆◆◆                                               ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    /**
     * Retourne la valeur actuellement affichée.
     * @return la valeur affichée sous forme de chaîne.
     */
    public String getCurrentDisplay() {
        return currentDisplay;
    }

    /**
     * Retourne la valeur actuellement affichée sous forme numérique.
     * @return la valeur affichée ou 0 si vide.
     */
    public Double getCurrentDisplayValue() {
        return currentDisplay.isEmpty() || currentDisplay.isBlank() ? 0 : Double.parseDouble(currentDisplay);
    }

    /**
     * Réinitialise l'affichage par défaut.
     */
    public void resetDisplay() {
        digits.clear();
        isNegative = false;
        errorType = EErrorType.NONE;
        isIntermediateValue = false;
        currentDisplay = "0";
    }

    /**
     * Met à jour l'affichage avec la valeur actuelle.
     */
    public void updateDisplay() {
        if (isErrorDisplayed()) return;
        currentDisplay = getTextValue();
    }

//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                                 ◆◆◆◆◆◆ STORE ◆◆◆◆◆◆                                                ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    /**
     * Efface la valeur stockée en mémoire.
     */
    public void clearMemoryStore() {
        storedValue = "";
    }

    /**
     * Vérifie si une valeur est stockée en mémoire.
     * @return true si aucune valeur valide n'est stockée.
     */
    public boolean isStoredValueValid() {
        return storedValue.isEmpty() || storedValue.isBlank();
    }

    /**
     * Stocke la valeur actuelle en mémoire.
     */
    public void storeValue() {
        if (isErrorDisplayed() || digits.isEmpty()) return;
        storedValue = currentDisplay;
    }

    /**
     * Affiche la valeur stockée depuis la mémoire.
     */
    public void displayStore() {
        if (isErrorDisplayed() || isStoredValueValid()) return;
        digits.clear();
        for (char c : storedValue.toCharArray()) {
            digits.add(c);
        }
        isIntermediateValue = true;
        currentDisplay = storedValue;
    }
}
