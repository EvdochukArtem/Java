class CalculatorApp
{
    public static void main(String[] args)
    {
        //String example = "(-10 +5^26) / (7^-15 + 8 - 1^0)";
        String example = "()";
        //String example = "5 - 3";
        Calculator calc = new Calculator();
        try
        {
            System.out.println(calc.calculate(example));
        } catch (InvalidExampleException ex) {}
    }
}