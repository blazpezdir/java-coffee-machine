import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int number = scanner.nextInt();

        int k = 0;
        boolean stopped = false;
        for (int i = 1; i <= number && !stopped; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i + " ");
                k++;
                if (k >= number) {
                    stopped = true;
                    break;
                }
            }
        }
    }
}