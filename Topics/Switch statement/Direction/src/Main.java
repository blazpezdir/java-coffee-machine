import java.util.Scanner;

class Main {

    private static final int NO_INPUT = 0;
    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int RIGHT = 4;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int direction = scanner.nextInt();

        switch (direction) {
            case NO_INPUT:
                System.out.print("do not move");
                break;
            case UP:
                System.out.print("move up");
                break;
            case DOWN:
                System.out.print("move down");
                break;
            case LEFT:
                System.out.print("move left");
                break;
            case RIGHT:
                System.out.print("move right");
                break;
            default:
                System.out.print("error!");
                break;
        }
    }
}