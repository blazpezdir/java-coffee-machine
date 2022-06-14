
class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        moveX(robot, toX);
        moveY(robot, toY);
    }

    private static void moveX(Robot robot, int toX) {
        // ROTATE FOR X POSITION CHANGE
        if (robot.getX() < toX) {
            // MOVE RIGHT
            // Rotate until in the right direction
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
        } else if (robot.getX() > toX) {
            // MOVE LEFT
            // Rotate until in the left direction
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnLeft();
            }
        }

        // MOVE IN THE X DIRECTION
        while (robot.getX() != toX) {
            // We are moving until we reach the destination
            robot.stepForward();
        }
    }

    private static void moveY(Robot robot, int toY) {
        // ROTATE FOR Y POSITION CHANGE
        if (robot.getY() < toY) {
            // MOVE UP
            // Rotate until in the up direction
            while (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
        } else if (robot.getY() > toY) {
            // MOVE DOWN
            // Rotate until in the down direction
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnRight();
            }
        }

        // MOVE IN THE Y DIRECTION
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}