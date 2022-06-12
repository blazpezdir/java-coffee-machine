import java.util.Scanner;

class Main {

    private static final char GRADE_A = 'A';
    private static final char GRADE_B = 'B';
    private static final char GRADE_C = 'C';
    private static final char GRADE_D = 'D';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int studentsCount = scanner.nextInt();
        int gradeASum = 0;
        int gradeBSum = 0;
        int gradeCSum = 0;
        int gradeDSum = 0;

        for (int i = 0; i < studentsCount; i++) {
            char grade = scanner.next().charAt(0);

            if (grade == GRADE_A) {
                gradeASum++;
            } else if (grade == GRADE_B) {
                gradeBSum++;
            } else if (grade == GRADE_C) {
                gradeCSum++;
            } else if (grade == GRADE_D) {
                gradeDSum++;
            }
        }

        System.out.println(gradeDSum + " " + gradeCSum + " " + gradeBSum + " " + gradeASum);
    }
}