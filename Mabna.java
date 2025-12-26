import java.util.Scanner;
public class Mabna {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Base Converter System ===");
        int sourceBase = 0;
        while (sourceBase < 2 || sourceBase > 16) {
            System.out.print("Enter source base (2-16): ");
            if (input.hasNextInt()) {
                sourceBase = input.nextInt();
            } else {
                System.out.println("Error: Please enter a valid integer.");
                input.next();
            }
        }
        String numberStr = "";
        boolean isNumberValid = false;
        while (!isNumberValid) {
            System.out.print("Enter the number in base " + sourceBase + ": ");
            numberStr = input.next().toUpperCase();

            if (isValidInBase(numberStr, sourceBase)) {
                isNumberValid = true;
            } else {
                System.out.println("Error! Digits do not match the source base.");
            }
        }
        int targetBase = 0;
        while (targetBase < 2 || targetBase > 16) {
            System.out.print("Enter target base (2-16): ");
            if (input.hasNextInt()) {
                targetBase = input.nextInt();
            } else {
                System.out.println("Error: Please enter a valid integer.");
                input.next(); // Clear invalid input
            }
        }
        try {
            long decimalValue = Long.parseLong(numberStr, sourceBase);
            String finalResult = Long.toString(decimalValue, targetBase).toUpperCase();

            System.out.println("\n------------------------------------");
            System.out.println("Conversion Result:");
            System.out.println("(" + numberStr + ") in base " + sourceBase + 
                               " = (" + finalResult + ") in base " + targetBase);
            System.out.println("------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println("Calculation Error! The number is too large for memory.");
        }
        input.close();
    }
    public static boolean isValidInBase(String number, int base) {
        String digits = "0123456789ABCDEF";
        String validRange = digits.substring(0, base);

        for (int i = 0; i < number.length(); i++) {
            if (validRange.indexOf(number.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}