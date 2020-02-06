import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest
{
    private Calculator calculator = new Calculator();

    @Test
    public void testCalculate1() throws InvalidExampleException
    {
        String infixExample = "(-10 +5^26) / (7^-15 + 8 - 1^0)";
        assertEquals("Wrong answer", 2.128737313406744e17, calculator.calculate(infixExample), 0.0001);
    }

    @Test
    public void testCalculate2() throws InvalidExampleException
    {
        assertEquals("Expected NaN", Double.NaN, calculator.calculate("123/0"), 0.0001);
    }
    @Test (expected = InvalidExampleException.class)
    public void testExceptionCalculate1() throws InvalidExampleException
    {
        calculator.calculate("()");
    }

    @Test (expected = InvalidExampleException.class)
    public void testExceptionCalculate2() throws InvalidExampleException
    {
        calculator.calculate("(-+))))0)00");
    }

    @Test (expected = InvalidExampleException.class)
    public void testExceptionCalculate3() throws InvalidExampleException
    {
        calculator.calculate("5 = 5");
    }

}