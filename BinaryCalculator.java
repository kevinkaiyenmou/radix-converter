import java.util.Scanner;

public class BinaryCalculator
{
    public static void main(String args[])
    {
        System.out.println("Please enter a Binary number you want to convert");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt(); //gets the number, i think
        //Ok so I think the concept is basically the same the last one except slightly easier
        int sum = 0;
        int digits = 1+(int) (Math.log(number)/Math.log(10)); //e = Euler's constant; log(number) is the x that satifies e^x = number; to convert from e to 10, we need to divide by log(10)
        for(int i = 0; i < digits; i++) //10^x = number and log(number) = x
        {
            //let's pretend number = 101, so the sum will be 4*1+2*0+1*1=5
            //we use 'number%10' for value in the one's place or least significant digit.
            //we use '(number/10)%10' for value in the ten's place
            //we use '(number/100)%10' for value in the hundred's place
            //a patterns emerges! We are dividing number by 10^i and then that modulus 10
            int twosPow = (int)Math.pow(2, i); 
            int tensPow = (int)Math.pow(10,i); 
            sum += twosPow*(number/tensPow)%10;  
            //when i = 0, twosPow = 1
            //when i = 0, tensPow = 1
            // when i = 0, sum += 1*(101/1)%10 = 1*(101%10) = 1*(1) = 1
            // sum = 1 
            //when i = 1, twosPow = 2
            //when i = 1, tensPow = 10
            // when i = 1, sum += 2*(101/10)%10 = 2*(10%10) = 2*(0) = 0
            // sum = 1 + 0
            //when i = 2, twosPow = 4
            //when i = 2, tensPow = 100
            // when i = 2, sum += 4*(101/100)%10 = 4*(1%10) = 4*(1) = 4
            // sum = 1 + 0 + 4
        }
        System.out.println("The base 2 number "+ number + " is "+ sum + " in base 10");
         
        input.close();
    }
}