import java.util.Random;
import java.util.Scanner;

class Anya_lab
{
    public static void main (String[] args)
    {
        int N;
        do
        {
            System.out.println("Enter integer N greater then zero:");
            Scanner sc = new Scanner("3");//System.in);
            if (sc.hasNextInt())
            {
                N = sc.nextInt();
                if (N > 0)
                    break;
            }
            System.out.println("Invalid input!");
        } while (true); //цикл для фильтрации входных параметров
        
        double A[] = new double[N+1];   //создаем массивы на 1 больше 
        double B[] = new double[N+1];   //тк в задании считают с 1 а не с 0

        Random rand = new Random(); //заполняем их случайными числами
        for (int i = 1; i < N+1; i++)
        {
            A[i] = rand.nextDouble();
            B[i] = rand.nextDouble();
        }

        System.out.println("Arrays: ");
        for (int i = 1; i < N + 1; i++)
        {
            System.out.print(A[i] + " ");
            System.out.print(B[i]);
            System.out.println();
        }

        int i, j;
        double max;
        int maxInd[] = new int[N];

        j = 0; max = 0.0;
        maxInd[0] = j;

        for (i = 1; i < N+1; i++)
            if (B[N-i+1] != 0)
                if (j == 0)
                {
                    maxInd[j] = i;
                    max = A[i]/B[N-i+1];
                    j++;
                } else
                if (max == A[i]/B[N-i+1])
                {
                    maxInd[j] = i;
                    j++;
                } else
                if (max < A[i]/B[N-i+1])
                {
                    max = A[i]/B[N-i+1];
                    maxInd[0] = i;
                    j = 1;
                }
        if (j == 0)
            System.out.println("Illegal expressions! Divided by zero");
        else
        {
            System.out.println("Maximum: " + max);
            System.out.print("Indexes: ");
            for (i = 0; i < j; i++)
                System.out.print(maxInd[i] + " ");
        }

        System.out.println("\nOk");
    }
}