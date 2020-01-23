class Calculator
{

    public static void main(String[] args)
    {
        String infixEx = "(a+b)/(c+d-1)";//"12*123-4+2/6";
        StackX <String> postfixEx = new StackX<>(new String[infixEx.length()]);

        convertInfixToPostfix(infixEx, postfixEx);
        postfixEx.show();  
    }

    private static void convertInfixToPostfix (String inputExample, StackX <String> outputExample)
    {
        inputExample += " ";
        char[] carr = inputExample.toCharArray();
        String number = "";
        StackX <Character> opStack = new StackX<>(new Character[inputExample.length()]);
        for (char c : carr) {
            //if (Character.isDigit(c))
            if (!isOperand(c) && c != ' ')
                number += c;
            else 
            {
                if (number != "")
                {
                    try
                    {
                        outputExample.push(number);
                    } catch (StackIsFullException ex)
                    {
                        System.out.println("postfixEx");
                    }
                    number = "";
                }
                if (isOperand(c))
                    try
                    {
                        switch (c)
                        {
                            case  '-':
                            case  '+':
                            
                                while (opStack.size() > 0 && opStack.peek() != '(')
                                    outputExample.push(Character.toString(opStack.pop()));
                                opStack.push(c);
                                break;

                            case '*':
                            case '/':
                                if (opStack.size() > 0 && opStack.peek() == c)
                                {
                                    outputExample.push(Character.toString(opStack.pop()));
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
                                    outputExample.push(Character.toString(opStack.pop()));
                                opStack.pop();
                                break;
                        }
                    } catch (StackIsFullException | StackIsEmptyException ex)
                    {
                        System.out.println("opStack");
                    }
            }
        }
        while (opStack.size() > 0)
            try 
            {
                outputExample.push(Character.toString(opStack.pop()));
            } catch (StackIsFullException | StackIsEmptyException ex)
            {
                System.out.println("outputStack");
            }
    }

    private static boolean isOperand (char inputChar)
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