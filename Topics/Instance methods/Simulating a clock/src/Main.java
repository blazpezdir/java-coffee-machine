
class Clock {

    final int maxMinutes = 59;
    final int maxHours = 12;
    int hours = 12;
    int minutes = 0;

    void next() {
        minutes++;
        if (minutes > maxMinutes) {
            hours++;
            minutes = 0;
            if (hours > maxHours) {
                hours = 1;
            }
        }
    }
}
