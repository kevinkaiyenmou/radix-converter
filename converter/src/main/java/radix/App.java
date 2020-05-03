package radix;

import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What base do you need converting (write the radix as a base 10 number)?");
        int base = input.nextInt();        
        System.out.println("Please enter a base " + base + " number to convert (separate place-values using ;)"); 
        String number = input.nextLine();
        //let's suppose 'base' = 36
        //let's suppose 'number' ='35;23;16'
        //First, we notice that we have 2 semicolons 
        // That means we have 3 numerals to deal with: '35','23','16'
        int sum = 0;
        String[] numbers = ArrayUtils.reverse(number.split(";")); //numbers[0] = 35; numbers[1] = 23; numbers[2] = 16;  
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i])*Math.pow(base, i);
        }
        
            //We will deal with each numeral successively (one after the other)
            
            //Let's deal with '16' first
            //And '16' is in the first location, so it is multiplied by 36⁰ (use 'sum' += 16*36⁰)
            
            //Next, is '23'
            //And '23' is in the second location, so it is multiplied by 36¹
            
            //Last, is '35'
            //And '35' is in the third location, so it is multiplied by 36²

        //Now we add the three numbers 16×36⁰ + 23×36¹ + 35×36² and return this to the user
        /* for (int i = 0; i < number.length(); i++) 
        {
            System.out.println("sum is "+ sum);
            double pow = Math.pow(16, hex.length() - i - 1);
            if(hex.charAt(i) >= '0' && hex.charAt(i)<='9'){
                sum += (hex.charAt(i) - '0')*pow;
            } else {
                sum += hexToInt.get(hex.toUpperCase().charAt(i))*pow;
            }
            //we also need to handle numers 0-9
            
        } */
        System.out.println("The base "+ base +" number "+ number + " is "+ sum + " in base 10");

        input.close();
    }
}
