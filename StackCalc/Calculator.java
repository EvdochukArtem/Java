class Calculator
{
    private String postfixEx;
    private StackX<Character> opStack;

    public String calculate(final String infixEx)
    {
        postfixEx = convertInfixToPostfix(infixEx.replaceAll(" ", ""));
        return calculatePostfixExample(postfixEx);
    }

    private String convertInfixToPostfix(final String inputExample)
    { // Надо отрефакторить - слишком длинный метод
        String result = "";
        String number = "";
        char[] carr = transformNegativeNumbers(inputExample).toCharArray();
        opStack = new StackX<>(new Character[inputExample.length()]);
        for (char c : carr) {
            if (!isOperand(c))
                number += c;
            else if (isOperand(c))
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
                        opStack.pop();
                        break;
                    }
                } catch (StackIsFullException | StackIsEmptyException ex) {
                    System.out.println("opStack");
                }
        }
        while (opStack.size() > 0)
            try {
                result += opStack.pop() + " ";
            } catch (StackIsEmptyException ex) {
                System.out.println("opStack");
            }
        if (number != "")
        result += number + " ";
        return result;
    }

    private static String calculatePostfixExample(final String postfixExample)
    { // Мб надо переделать метод с использованием стека
        String[] exampleElements = postfixExample.split(" ");
        for (int i = 2; i < exampleElements.length; i++)
        {
            if (exampleElements[i].length() == 1 && isOperand(exampleElements[i].charAt(0)))
            {
                double var1 = Double.parseDouble(exampleElements[i-2]);
                double var2 = Double.parseDouble(exampleElements[i-1]);
                char operation = exampleElements[i].charAt(0);  
                exampleElements[i] = solveExample(var1, var2, operation);
            }
        }
        return new String("");
    }

    private static String solveExample(double var1, double var2, char operation)
    {
        double result;
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
                result = 0.0;
                new Exception("Example is unsolved!");
                break;
        }
        return Double.toString(result);
    }

    private static String transformNegativeNumbers(final String inputExample)
    { // Мб надо переделать метод с использованием лямбд
        StringBuffer transformedExample = new StringBuffer(inputExample);
        for (int i = 1; i < transformedExample.length(); i++)
            if (isOperand(transformedExample.charAt(i - 1)) && transformedExample.charAt(i) == '-') {
                transformedExample.insert(i, "(0");
                int j = i + 3;
                while (!isOperand(transformedExample.charAt(j)) && j < transformedExample.length())
                    j++;
                transformedExample.insert(j, ")");
            }
        if (transformedExample.charAt(0) == '-')
            transformedExample.insert(0, "0");
        return new String(transformedExample);
    }

    private static boolean isOperand(final char inputChar)
    {
        boolean isOperand = true;
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
            isOperand = false;
            break;
        }
        return isOperand;
    }
}