import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        long m = scanner.nextLong();

        int factorialBase = 1;
        long factorialResult = 1;

        while (factorialResult <= m) {
            factorialBase++;
            factorialResult *= factorialBase;
        }

        System.out.println(factorialBase);
    }
}