import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//don't know what do import so leaving this blank for now
//probably nothing.
//maybe the math thing

public class BaseCalculator
{
    
    public static void main(String args[])
    {
        System.out.println("Please enter a Hexadecimal number to convert"); 
        Scanner input = new Scanner(System.in);
        String hex = input.nextLine();
        //let's suppose we got '3AE'
        //First, we notice that we have three numerals to deal with: '3','A','E'
            
            //We will deal with each numeral successively (one after the other)
            
            //Let's deal with 'E' first
            //'E' means 14
            //And 'E' is in the first location, so it is multiplied by 16⁰ (use 'sum' += the product of the numeral and power of 16)
            
            //Next, is 'A'
            //'A' means 10
            //And 'A' is in the second location, so it is multiplied by 16¹
            
            //Last, is '3'
            //'3' means 3
            //And '3' is in the third location, so it is multiplied by 16²
        //Now we sum the three numbers 14×16⁰ + 10×16¹ + 3×16² and return this to the user
        Map<Character,Integer> hexToInt = new HashMap<Character,Integer>();
        hexToInt.put('A',10);
        hexToInt.put('B',11);
        hexToInt.put('C',12);
        hexToInt.put('D',13);
        hexToInt.put('E',14);
        hexToInt.put('F',15);
        int sum = 0;
        for (int i = 0; i < hex.length(); i++) 
        {
            System.out.println("sum is "+ sum);
            double pow = Math.pow(16, hex.length() - i - 1);
            if(hex.charAt(i) >= '0' && hex.charAt(i)<='9'){
                sum += (hex.charAt(i) - '0')*pow;
            } else {
                sum += hexToInt.get(hex.toUpperCase().charAt(i))*pow;
            }
            //we also need to handle numers 0-9
            
        }
        System.out.println("The base 16 number "+ hex + " is "+ sum + " in base 10");

        input.close();
    }                                                                                               
}
