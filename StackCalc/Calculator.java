class Calculator
{

    private static String infixEx;
    private static String postfixEx;
    private static StackX <Character> opStack;
    public static void main(String[] args)
    {
        postfixEx = "";
        infixEx = "(-a +b^2) / (c^-a + d - 1^0)";//"12*123-4+2/6";
        convertInfixToPostfix(infixEx.replaceAll(" ",""));
        System.out.println(postfixEx);
    }

    /*private static double calculate (final String inputPostfixEx)
    {
        double result;
        return result;
    }*/

    private static void convertInfixToPostfix (final String inputExample)
    {   //Надо отрефакторить - слишком длинный метод        
        char[] carr = transformNegativeNumbers(inputExample).toCharArray();
        opStack = new StackX<>(new Character[inputExample.length()]);
        for (char c : carr) {
            if (!isOperand(c))
                postfixEx += c + " ";
            else 
                if (isOperand(c))
                    try
                    {
                        switch (c)
                        {
                            case  '-':
                            case  '+':
                                while (opStack.size() > 0 && opStack.peek() != '(')
                                    postfixEx += opStack.pop() + " ";
                                opStack.push(c);
                                break;
                            case '*':
                            case '/':
                            case '^':
                                if (opStack.size() > 0 && opStack.peek() == c)
                                {
                                    postfixEx += opStack.pop() + " ";
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
                                    postfixEx += opStack.pop() + " ";
                                opStack.pop();
                                break;
                        }
                    } catch (StackIsFullException | StackIsEmptyException ex)
                    {
                        System.out.println("opStack");
                    }
        }
        while (opStack.size() > 0)
            try 
            {
                postfixEx += opStack.pop() + " ";
            } catch (StackIsEmptyException ex)
            {
                System.out.println("outputStack");
            }
    }

    private static String transformNegativeNumbers (final String inputExample)
    {   //Мб надо переделать метод с использованием лямбд
        StringBuffer transformedExample = new StringBuffer(inputExample);
        for (int i = 1; i < transformedExample.length(); i++)
            if (isOperand(transformedExample.charAt(i-1)) && transformedExample.charAt(i) == '-')
            {
                transformedExample.insert(i,"(0");
                int j = i+3;
                while (!isOperand(transformedExample.charAt(j)) && j < transformedExample.length())
                    j++;
                transformedExample.insert(j,")");
            }
        if (transformedExample.charAt(0) == '-')
            transformedExample.insert(0,"0");
        return new String(transformedExample);
    }

    private static boolean isOperand (final char inputChar)
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