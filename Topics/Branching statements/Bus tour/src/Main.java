import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int busHeight = scanner.nextInt();
        int bridgeCount = scanner.nextInt();

        boolean crashed = false;

        for (int i = 1; i <= bridgeCount; i++) {
            int bridgeHeight = scanner.nextInt();

            if (busHeight >= bridgeHeight) {
                crashed = true;
                System.out.println("Will crash on bridge " + i);
                break;
            }
        }

        if (!crashed) {
            System.out.println("Will not crash");
        }
    }
}