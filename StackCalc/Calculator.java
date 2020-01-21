class Calculator
{
    private static String example;
    private static StackX <Character> opStack;
    private static StackX <Double> numStack;

    public static void main(String[] args)
    {
        String example = "12+123";
        double[] numArr = new double[example.length()];
        char[] opArr = new char[example.length()];
        readExample(numArr, opArr, example);
        for (double d : numArr) {
            System.out.println(d);
        }
        for (char c : opArr) {
            System.out.println(c);
        }        
    }

    private static void readExample (double[] nArr, char[] oArr, String inputExample)
    {
        int i = 0;
        int j = 0;
        inputExample += " ";
        char[] carr = inputExample.toCharArray();
        String number = "";
        for (char c : carr) {
            if (Character.isDigit(c))
                number += c;
            else 
            {
                if (number != "")
                {
                    nArr[j++] = Double.parseDouble(number);
                    number = "";
                }
                if (isOperand(c))
                    oArr[i++] = c;
            }
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
                break;
            default:
                isOperand = false;
                break;
        }
        return isOperand;
    }
}