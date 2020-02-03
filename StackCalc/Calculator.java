class Calculator
{
    public Double calculate(final String infixEx)
    {
        if (!isCorrect(infixEx))
        {
            System.out.println("Example isn't correct. Use only digits and operators +,-,*,/,^!");
            return null;
        }    
        String postfixEx = convertInfixToPostfix(infixEx.replaceAll(" ", ""));
        System.out.println(postfixEx);
        return calculatePostfixExample(postfixEx);
    }

    private String convertInfixToPostfix(final String inputExample)
    { // Надо отрефакторить - слишком длинный метод и возможно есть ошибки 
        String result = "";
        String number = "";
        char[] carr = transformNegativeNumbers(inputExample).toCharArray();
        StackX<Character> opStack = new StackX<>(new Character[inputExample.length()]);
        for (char c : carr) {
            if (!isOperator(c))
                number += c;
            else if (isOperator(c))
                try {
                    if (number != "")
                    {
                        result += number + " ";
                        number = "";
                    }
                    switch (c) {
                    case '-':
                    case '+':
                        while (opStack.size() > 0 && opStack.peek() != '(')
                            result += opStack.pop() + " ";
                        opStack.push(c);
                        break;
                    case '*':
                    case '/':
                    case '^':
                        if (opStack.size() > 0 && opStack.peek() == c) {
                            result += opStack.pop() + " ";
                            opStack.push(c);
                        } else {
                            opStack.push(c);
                        }
                        break;
                    case '(':
                        opStack.push(c);
                        break;
                    case ')':
                        while (opStack.size() > 0 && opStack.peek() != '(')
                            result += opStack.pop() + " ";
                        opStack.pop(); // страно что ошибку не выдает тк метод поидее возвращает char
                        break;
                    }
                } catch (StackIsFullException | StackIsEmptyException ex) {
                    System.out.println("opStack");
                }
        }
        if (number != "")
            result += number + " ";
        while (opStack.size() > 0)
            try {
                result += opStack.pop() + " ";
            } catch (StackIsEmptyException ex) {
                System.out.println("opStack");
            }
        return result;
    }

    private static Double calculatePostfixExample(final String postfixExample)
    {
        Double result;
        String[] exampleElements = postfixExample.split(" ");
        StackX <Double> exampleStack = new StackX <> (new Double[exampleElements.length]);

        for (int i = 0; i < exampleElements.length; i++)
            if (exampleStack.size() >= 2 && exampleElements[i].length() == 1 && isOperator(exampleElements[i].charAt(0)))
                try {
                    double var2 = exampleStack.pop();
                    double var1 = exampleStack.pop();
                    char operation = exampleElements[i].charAt(0);  
                    exampleStack.push(solveExample(var1, var2, operation));
                } catch (StackIsEmptyException | StackIsFullException ex) {
                    System.out.println("Calculations");
                }
            else
                try {
                    exampleStack.push(Double.parseDouble(exampleElements[i]));
                } catch (StackIsFullException ex) {
                    System.out.println("Calculations");
                }
        try {
            result = exampleStack.peek();
        } catch (StackIsEmptyException ex) {
            result = null;
            System.out.println("Calculations");
        }
        return result;
    }

    private static Double solveExample(double var1, double var2, char operation)
    {
        Double result;
        switch (operation)
        {
            case '-':
                result = var1 - var2;
                break;
            case '+':
                result = var1 + var2;
                break;
            case '*':
                result = var1 * var2;
                break;
            case '/':
                result = var1 / var2;
                break;
            case '^':
                result = Math.pow(var1, var2);
                break;
            default:
                result = null;
                new Exception("Example is unsolved!");
                break;
        }
        return result;
    }

    private static String transformNegativeNumbers(final String inputExample)
    { // Мб надо переделать метод с использованием лямбд
        StringBuffer transformedExample = new StringBuffer(inputExample);
        for (int i = 1; i < transformedExample.length(); i++)
            if (isOperator(transformedExample.charAt(i - 1)) && transformedExample.charAt(i) == '-') {
                transformedExample.insert(i, "(0");
                int j = i + 3;
                while (!isOperator(transformedExample.charAt(j)) && j < transformedExample.length())
                    j++;
                transformedExample.insert(j, ")");
            }
        if (transformedExample.charAt(0) == '-')
            transformedExample.insert(0, "0");
        return new String(transformedExample);
    }

    private static boolean isOperator(final char inputChar)
    {
        boolean isOperator = true;
        switch (inputChar) {
        case '+':
        case '-':
        case '*':
        case '/':
        case '^':
        case '(':
        case ')':
            break;
        default:
            isOperator = false;
            break;
        }
        return isOperator;
    }

    private boolean isCorrect(final String inputExample)
    {
        boolean isCorrect = true;
        for (char c: inputExample.toCharArray())
            if (!Character.isDigit(c) && !isOperator(c) && c != ' ')
            {
                isCorrect = false;
                break;
            }
        return isCorrect;
    }
}