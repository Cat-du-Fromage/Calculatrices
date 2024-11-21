package calculator;

import java.util.*;

public class State
{
    private Stack<String> stack = new Stack<String>();

    private ArrayList<Character> digits = new ArrayList<Character>();

    private boolean isNegativ = false;

    private EErrorType errorType = EErrorType.NONE;

    private String currentDisplay = "";

    private String storedValue = "";

    private boolean isIntermediateValue = false;

    //private String intermediateValue = "";

    public State()
    {
        resetDisplay();
    }

    public boolean isNegativ()
    {
        return isNegativ;
    }

    public void toggleNegative()
    {
        if(isErrorDisplayed()) return;
        isNegativ = !isNegativ;
        setCurrentDisplay();
    }

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
        setCurrentDisplay();
        isIntermediateValue = true;
    }

    public void storeValue()
    {
        if(isErrorDisplayed() || digits.isEmpty()) return;
        storedValue = currentDisplay;
    }

    public void displayStore()
    {
        if(isErrorDisplayed() || storedValue.isEmpty() || storedValue.isBlank()) return;
        digits.clear();
        for(char c : storedValue.toCharArray())
        {
            digits.add(c);
        }
        currentDisplay = storedValue;
    }

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

    public boolean hasSyntaxError()
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

    public Stack<String> getStack()
    {
        return stack;
    }

    public Double popStack()
    {
        return stack.isEmpty() ? 0.0 : Double.parseDouble(stack.pop());
    }

    public void resetStack()
    {
        stack.clear();
    }

    public ArrayList<Character> getDigits()
    {
        return digits;
    }

    public String getTextValue()
    {
        StringBuilder valueString = new StringBuilder();
        if(isNegativ) valueString.append('-');
        if(digits.isEmpty()) valueString.append('0');
        for (Character digit : digits)
        {
            valueString.append(digit);
        }
        return valueString.toString();
    }

    public void commitDigit(Character digit)
    {
        if(isErrorDisplayed()) return;
        if(isIntermediateValue)
        {
            addToStack();
        }
        digits.add(digit);
        setCurrentDisplay();
    }

    public void addToStack()
    {
        if(!checkSyntaxError())
        {
            stack.push(getTextValue());
            isIntermediateValue = false;
            resetDisplay();
        }
    }

    public String getCurrentDisplay()
    {
        return currentDisplay;
    }

    public void resetDisplay()
    {
        digits.clear();
        isNegativ = false;
        errorType = EErrorType.NONE;
        isIntermediateValue = false;
        currentDisplay = "0";
    }

    public void setCurrentDisplay()
    {
        if(isErrorDisplayed()) return;
        currentDisplay = getTextValue();
    }
}
