class Calculator
{
    /**
     * Checkes input string with infix example to be corrected in inputExampleIsCorrect method,
     * and if string contains only allowed symbols method converts infix example to postfix in
     * convertInfixToPostfix method, writes result on convertion and returns calculated double
     * number by calculatePostfixExample method.
     * @param infixEx string with infix example to be calculated.
     * @return double number if examle is correct and sovlable, otherwise throws InvalidExampleException.
     */
    public Double calculate(final String infixEx) throws InvalidExampleException
    {
        if (!inputExampleIsCorrect(infixEx))
        {
            System.out.println("Example isn't correct. Use only digits and operators +,-,*,/,^!");
            throw new InvalidExampleException();
        }    
        String postfixEx = convertInfixToPostfix(infixEx.replaceAll(" ", ""));
        System.out.println(postfixEx);
        return calculatePostfixExample(postfixEx);
    }

    /**
     * Method converts string with infix example to postfix. It transforms negative numbers to a suitable
     * form in transformNegativeNumbers method, breaks string to char array. Then if char sequence forms
     * number it writes it to result string. If char is operator it compares math operation priority with
     * stack peek operator, insert most priority operator to result string and push least priority to stack.
     * When all chars in array are checked, remaining operators from stack inserts to result string.
     * @param inputExample string with infix example to be converted
     * @return result string with postfix form of input example.
     */
    private String convertInfixToPostfix(final String inputExample)
    { // Надо отрефакторить - слишком длинный метод и возможно есть ошибки 
        String result = "";
        String number = "";
        char[] cArr = transformNegativeNumbers(inputExample).toCharArray();
        StackX<Character> opStack = new StackX<>(new Character[inputExample.length()]);
        for (char c : cArr) {
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

    /**
     * Takes postfix example, split it to the elements of numbers and operators.
     * Then one by one pushes elements to the stack if the are numbers. If element
     * is operator, then extracts last two elements from stack and do calculations
     * with solveExample method. If everthing ok stack will contains only one number
     * which is the answer.
     * @param postfixExample string which contains example to be calculated.
     * @return Double number that is the answer or throws InvalidExampleException if example is unsolvable.
     */
    private static Double calculatePostfixExample(final String postfixExample) throws InvalidExampleException
    {
        if (postfixExample == "" || postfixExample == null)
            throw new InvalidExampleException();

        Double result;
        String[] exampleElements = postfixExample.split(" ");
        StackX <Double> exampleStack = new StackX <> (new Double[exampleElements.length]);

        for (int i = 0; i < exampleElements.length; i++)
            if (exampleElements[i].length() == 1 && isOperator(exampleElements[i].charAt(0)))
                if (exampleStack.size() < 2)
                    throw new InvalidExampleException();
                else try {
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
            result = Double.NaN;
            System.out.println("Calculations");
        }
        return result;
    }

    /**
     * Method takes two double numbers and one char operator to solve the example.
     * @param var1 first double operand.
     * @param var2 second double operand.
     * @param operation char symbol of operation to be done with operands.
     * @return Double result of operation or NaN if operation cant be done.
     */
    private static Double solveExample(double var1, double var2, char operation)
    {
        Double result;
        try
        {
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
                    if (var2 == 0)
                        result = Double.NaN;
                    else
                        result = var1 / var2;
                    break;
                case '^':
                    result = Math.pow(var1, var2);
                    break;
                default:
                    result = Double.NaN;
                    new Exception("Wrong operator!");
                    break;
            }
        } catch (Exception ex)
        {
            System.out.println(ex);
            result = Double.NaN;
        } 
        
        return result;
    }

    /**
     * Transforms all negative numbers (like -123) in input string which contains
     * infix example to usable form ((0-123)) for further postfix transformation.
     * @param inputExample string to be transformed.
     * @return string with transformed negaive number suitable for postfix transformation.
     */
    private static String transformNegativeNumbers(final String inputExample)
    { // Мб надо переделать метод с использованием лямбд
        StringBuffer transformedExample = new StringBuffer(inputExample);
        for (int i = 0; i < transformedExample.length() - 1; i++)
            if (isOperator(transformedExample.charAt(i)) && transformedExample.charAt(i + 1) == '-') {
                transformedExample.insert(i + 1, "(0");
                int j = i + 1 + 3;
                while (!isOperator(transformedExample.charAt(j)) && j < transformedExample.length())
                    j++;
                transformedExample.insert(j, ")");
            }
        return new String(transformedExample);
    }

    /**
     * Checkes whether input char matches any allowed operators.
     * @param inputChar char to be checked.
     * @return true if char matches allowed operators, false otherwise.
     */
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

    /**
     * Checkes whether string contains only digits, whitespaces and allowed operators.
     * @param inputExample String to checked.
     * @return true if string contains only allowed symbols, false otherwise.
     */
    private boolean inputExampleIsCorrect(final String inputExample)
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