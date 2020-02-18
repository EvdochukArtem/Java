import java.io.*;

class CalculatorApp
{
    public static void main(String[] args)
    {
        System.out.print("Enter example: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calculator calc = new Calculator();
        while(true)
        try
        {
            String example = br.readLine();
            if (example.equals("exit"))
                break;
            else
                System.out.println(example + " = " + calc.calculate(example));
        } 
        catch (InvalidExampleException|IOException ex) {
            System.out.print("Invalid input, try again:");
        }        
    }
}