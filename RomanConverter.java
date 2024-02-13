import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanConverter {
    private Map<Character, Integer> romanNumerals;

    public RomanConverter() {
        romanNumerals = new HashMap<>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
    }

    public int romanToInteger(String roman) {
        int convertedNumber = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char numeral = roman.charAt(i);
            int value = romanNumerals.get(numeral);

            if (value < prevValue) {
                convertedNumber -= value;
            } else {
                convertedNumber += value;
            }
            prevValue = value;
        }

        return convertedNumber;
    }

    public static void main(String[] args) {
        RomanConverter converter = new RomanConverter();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a Roman numeral (or 'exit' to quit): ");
            String romanInput = scanner.nextLine().toUpperCase();

            if ("EXIT".equals(romanInput)) {
                break;
            }

            try {
                int convertedNumber = converter.romanToInteger(romanInput);
                System.out.println("The numeric value of " + romanInput + " is: " + convertedNumber);
            } catch (NullPointerException e) {
                System.out.println("Invalid Roman numeral: " + romanInput);
            }
        }

        scanner.close();
    }
}
