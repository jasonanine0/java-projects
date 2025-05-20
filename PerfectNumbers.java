/*
* PerfectNumbers.java
* This program calculates perfect numbers in a given range.
* A perfect number equals the sum of its positive divisors (excluding itself).
* Example: 6 has divisors 1, 2, 3 and 1+2+3 = 6
* 
* The program first finds perfect numbers from 1-200,
* then lets the user choose a custom upper limit.
*/

import java.util.Scanner;

public class PerfectNumbers {
    
    public static void main(String[] args) {
        // Show perfect numbers from 1 to 200
        System.out.println("Perfect numbers from 1 to 200:");
        findPerfects(200);
        
        // Let user set their own limit
        userSetLimit();
    }
    
    // Checks if a number is perfect (equals sum of its divisors)
    static boolean checkPerfect(long number) {
        // Perfect numbers must be positive
        if (number < 1) {
            return false;
        }
        
        // Find divisors and sum them
        long divisorSum = 0;
        for (long i = 1; i < number; i++) {
            // If i divides number evenly, it's a divisor
            if (number % i == 0) {
                divisorSum += i;
            }
        }
        
        // Number is perfect if it equals sum of its divisors
        return divisorSum == number;
    }
    
    // Find perfect numbers up to a limit
    static void findPerfects(long limit) {
        // Check each number from 1 to the limit
        for (long num = 1; num <= limit; num++) {
            if (checkPerfect(num)) {
                System.out.println(num);
            }
        }
        System.out.println(); // Empty line for better readability
    }
    
    // Let user choose their own upper limit
    static void userSetLimit() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Find perfect numbers up to what value?");
        System.out.print("Enter number: ");
        
        try {
            // Get user's chosen limit
            long userLimit = input.nextLong();
            
            // Make sure it's positive
            if (userLimit <= 0) {
                System.out.println("Please use a positive number.");
                input.close();
                return;
            }
            
            // Warn about large values
            if (userLimit > 10000) {
                System.out.println("Warning: Large values may take a long time to calculate.");
                System.out.print("Continue? (y/n): ");
                String answer = input.next();
                
                if (answer.charAt(0) != 'y' && answer.charAt(0) != 'Y') {
                    System.out.println("Operation canceled.");
                    input.close();
                    return;
                }
            }
            
            // Show results
            System.out.println("\nPerfect numbers from 1 to " + userLimit + ":");
            findPerfects(userLimit);
            
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            input.close();
        }
    }
}