package calculator;

//import java.util.*;
//import calculator.util.*;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;


public class State
{
    private Stack<String> stack = new Stack<String>();

    private ArrayList<Character> digits = new ArrayList<Character>();

    private boolean isNegative = false;

    private EErrorType errorType = EErrorType.NONE;

    private String currentDisplay = "";

    private String storedValue = "";

    private boolean isIntermediateValue = false;

    public State()
    {
        resetDisplay();
    }

//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                                ◆◆◆◆◆◆ DIGITS ◆◆◆◆◆◆                                                ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    public String getTextValue()
    {
        StringBuilder valueString = new StringBuilder();
        if(isNegative) valueString.append('-');
        if(digits.isEmpty()) valueString.append('0');
        for (Character digit : digits)
        {
            valueString.append(digit);
        }
        return valueString.toString();
    }

    public int digitsLength(){
        return digits.size();
    }

    public boolean isDecimalValue()
    {
        return digits.contains('.');
    }

    public char lastInput()
    {
        return digits.isEmpty() ? '0' : digits.getLast();
    }

    public void commitDigit(Character digit)
    {
        //if(isIntermediateValue) {addToStack();}
        digits.add(digit);
    }

    public boolean isNegative()
    {
        return isNegative;
    }

    public void toggleSign()
    {
        isNegative = !isNegative;
    }
//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                          ◆◆◆◆◆◆ INTERMEDIATE VALUE ◆◆◆◆◆◆                                          ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝
    public boolean isIntermediateValue()
    {
        return isIntermediateValue;
    }

    public void setIntermediateValue(String value)
    {
        digits.clear();
        for(char c : value.toCharArray())
        {
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
    public Stack<String> getStack(){return stack;}

    public Double popStack()
    {
        return stack.isEmpty() ? 0.0 : Double.parseDouble(stack.pop());
    }

    //MANQUE clear
    public void resetStack()
    {
        stack.clear();
    }

    public void addToStack()
    {
        //conversion pour supprimer les 0 inutiles après la virgule
        Double value = Double.parseDouble(getTextValue());
        stack.push(value.toString());
        isIntermediateValue = false;
        resetDisplay();
    }

    public boolean isDigitEmpty()
    {
        return digits.isEmpty();
    }

    public void removeLastDigit()
    {
        digits.removeLast();
    }

//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                                 ◆◆◆◆◆◆ ERROR ◆◆◆◆◆◆                                                ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    public boolean isErrorDisplayed()
    {
        return Arrays.stream(EErrorType.values()).anyMatch(eErrorType -> eErrorType.name().equals(currentDisplay));
    }

    public void setErrorType(EErrorType type)
    {
        errorType = type;
        if(errorType != EErrorType.NONE)
        {
            currentDisplay = errorType.name();
        }
    }

    private boolean hasSyntaxError()
    {
        //return digits.stream().filter(c -> c == '.').count() > 1;
        int count = 0;
        for (char c : digits)
        {
            count += c == '.' ? 1 : 0;
        }
        return count > 1;
    }

    public boolean checkSyntaxError()
    {
        boolean hasSyntaxError = hasSyntaxError();
        if(hasSyntaxError)
        {
            errorType = EErrorType.SYNTAX_ERROR;
            currentDisplay = EErrorType.SYNTAX_ERROR.name();
        }
        return hasSyntaxError;
    }
//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                                ◆◆◆◆◆◆ DISPLAY ◆◆◆◆◆◆                                               ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    public String getCurrentDisplay()
    {
        return currentDisplay;
    }

    public Double getCurrentDisplayValue()
    {
        return currentDisplay.isEmpty() || currentDisplay.isBlank() ? 0 : Double.parseDouble(currentDisplay);
    }

    public void resetDisplay()
    {
        digits.clear();
        isNegative = false;
        errorType = EErrorType.NONE;
        isIntermediateValue = false;
        currentDisplay = "0";
    }

    public void updateDisplay()
    {
        if(isErrorDisplayed()) return;
        currentDisplay = getTextValue();
    }

//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                                 ◆◆◆◆◆◆ STORE ◆◆◆◆◆◆                                                ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    public void clearMemoryStore()
    {
        storedValue = "";
    }

    public boolean isStoredValueValid()
    {
        return storedValue.isEmpty() || storedValue.isBlank();
    }

    public void storeValue()
    {
        if(isErrorDisplayed() || digits.isEmpty()) return;
        storedValue = currentDisplay;
    }

    public void displayStore()
    {
        if(isErrorDisplayed() || isStoredValueValid()) return;
        digits.clear();
        for(char c : storedValue.toCharArray())
        {
            digits.add(c);
        }
        isIntermediateValue = true;
        currentDisplay = storedValue;
    }
}
