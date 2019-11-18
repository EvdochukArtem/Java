package StackCalc;

class Calculator
{
    private static String example;
    private static StackX <Character> opStack;
    private static StackX <Double> numStack;

    public static void main(String[] args)
    {
    	Double[] ar = {21.0, 123.5};
    	numStack = new StackX(ar);
    	System.out.println("1234");
        //example = "12+123";
        //char[] carr = example.toCharArray();
        //Character[] Carr = IntStream.range(0, carr.length).mapToObj(int i->carr[i]).toArray(Character[]::new);
        //opStack = new opStack(Carr);

    }
}
}