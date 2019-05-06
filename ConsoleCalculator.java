import java.util.Scanner;

public class ConsoleCalculator{
    public static void main(String[] args) {
       
        System.out.print("Enter an example: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(calc(s));
    }

    static double calc(String InputExample) {

        char[] example = InputExample.toCharArray();
        int[] operand = new int[example.length*2/3+1];
        char[] operator = new char[example.length/3+1];
        int i, ii = 0, jj  = 0, j = 1;
        for (i = 0; i < example.length; i++)
        {
            
            if (Character.isDigit(example[i]))
            {
                operand[ii] *= j;
                operand[ii] += (Character.getNumericValue(example[i]));
                j *= 10;
            }
            else if (example[i] != ' ')
            {
                j = 1;
                ii++;
                operator[jj] = example[i];
                jj++;
            }
        }
        double result;
        switch (operator[0]){
            case '+': result = operand[0] + operand[1];
                    break;
            case '-': result = operand[0] - operand[1];
                    break;
            case '*': result = operand[0] * operand[1];
                    break;
            case '/': result = operand[0] / operand[1];
                    break;
            case '^': result = Math.pow(operand[0], operand[1]);
                    break;
            default: result = 1331.0;
        }
        return result;
    }
}