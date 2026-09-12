import java.util.Scanner;

public class InputReader {
    private static final Scanner scanner = new Scanner(System.in);
    // Purpose: This class ensures user input matches the expected data type, preventing program crashes (Exceptions).
    //
    // HOW IT WORKS:
    // 1. Inside the loop, scanner.hasNextBoolean() checks the input buffer. Since the buffer is empty, it pauses and waits for user input.
    // 2. It acts as the "validator": if the input is a valid boolean, it returns true.
    // 3. Then, scanner.nextBoolean() instantly grabs that checked value from the buffer without pausing the program again.
    // 4. If the input is invalid, scanner.nextLine() is used to clear the bad text out of the buffer so the user can try again.


    // 1. SAFE INT READER
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // Clear the leftover newline!
                return value;
            }
            String invalid = scanner.nextLine(); // Clear the whole bad line
            System.out.println("Error: '" + invalid + "' is not a valid integer. Try again.");
        }
    }

    // 2. SAFE DOUBLE READER
    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine(); // Clear the leftover newline!
                return value;
            }
            String invalid = scanner.nextLine();
            System.out.println("Error: '" + invalid + "' is not a valid decimal number. Try again.");
        }
    }

    // 3. SAFE BOOLEAN READER
    public static boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextBoolean()) {
                boolean value = scanner.nextBoolean();
                scanner.nextLine(); // Clear the leftover newline!
                return value;
            }
            String invalid = scanner.nextLine();
            System.out.println("Error: '" + invalid + "' is not a valid boolean (true/false). Try again.");
        }
    }

    // 4. SAFE STRING READER
    public static String readString(String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine();
        return value;
    }
}
