import java.util.Arrays;
import java.util.Scanner;

public class CalculatorStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        String input = scanner.nextLine();
        Main result = new Main();
        Main result2 = new Main();
        String answer = result.calc(input);
        System.out.println("Output: "+ answer);
    }
}
