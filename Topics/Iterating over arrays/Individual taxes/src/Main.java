import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Instantiate new scanner
        Scanner scanner = new Scanner(System.in);

        // Read company count input line
        int companyCount = scanner.nextInt();

        // Read income input line
        int[] income = new int[companyCount];
        for (int i = 0; i < income.length; i++) {
            income[i] = scanner.nextInt();
        }

        // Read tax percent input line
        int[] taxPercent = new int[companyCount];
        for (int i = 0; i < taxPercent.length; i++) {
            taxPercent[i] = scanner.nextInt();
        }

        // Calculate tax
        int[] tax = new int[companyCount];
        for (int i = 0; i < tax.length; i++) {
            tax[i] = income[i] * taxPercent[i];
        }

        int maxAmount = 0;
        int company = 0;
        // Find biggest tax payer
        for (int i = 0; i < tax.length; i++) {
            if (tax[i] > maxAmount) {
                company = i + 1;
                maxAmount = tax[i];
            }
        }

        // Print result to console
        System.out.println(company);
    }
}