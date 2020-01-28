class CalculatorApp
{
    public static void main(String[] args)
    {
        String example = "(-a +b^26) / (c^-15 + d - 1^0)";
        Calculator calc = new Calculator();
        System.out.println(calc.calculate(example));

    }
}