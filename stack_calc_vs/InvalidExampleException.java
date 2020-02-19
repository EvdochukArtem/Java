public class InvalidExampleException extends Exception
{
    private static final long serialVersionUID = -18347623147022887L;

    InvalidExampleException()
    {
        System.out.println("Example isn't correct. Use only digits and operators +,-,*,/,^!");
    }
}