import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();

        int[] numbers = new int[len];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();

        int count = 0;
        for (int number : numbers) {
            if (number == n) {
                count++;
            }
        }

        System.out.println(count);
    }
}