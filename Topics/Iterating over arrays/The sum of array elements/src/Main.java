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

        int result = 0;
        for (int num : numbers) {
            result += num;
        }

        System.out.println(result);
    }
}