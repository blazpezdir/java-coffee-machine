package machine;

import java.util.Scanner;

enum CoffeeType {
    ESPRESSO(4, 250, 0, 16), LATTE(7, 350, 75, 20), CAPPUCCINO(6, 200, 100, 12);

    private final int price;
    private final int water;
    private final int milk;
    private final int beans;

    CoffeeType(int price, int water, int milk, int beans) {
        this.price = price;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
    }

    public float getPrice() {
        return this.price;
    }

    public float getWater() {
        return this.water;
    }

    public float getMilk() {
        return this.milk;
    }

    public float getBeans() {
        return this.beans;
    }
}
public class CoffeeMachine {
    enum State {
        MENU, BUY, FILL
    }
    private State state = State.MENU;
    private int fillStep = 1;

    // Initial values
    private static int water;
    private static int milk;
    private static int beans;
    private static int cups;
    private static int money;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public void displayInstructions() {
        switch(state) {
            case MENU:
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case BUY:
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case FILL:
                switch(fillStep) {
                    case 1:
                        System.out.println();
                        System.out.println("Write how many ml of water you want to add:");
                        break;
                    case 2:
                        System.out.println("Write how many ml of milk you want to add:");
                        break;
                    case 3:
                        System.out.println("Write how many grams of coffee beans you want to add:");
                        break;
                    case 4:
                        System.out.println("Write how many disposable cups of coffee you want to add:");
                        break;
                }
                break;
        }
    }
    public void processUserInput(String input) {
        if (this.state == State.MENU) {
            switch(input) {
                case "buy":
                    this.state = State.BUY;
                    break;
                case "fill":
                    this.state = State.FILL;
                    break;
                case "take":
                    this.take();
                    break;
                case "remaining":
                    this.remaining();
                    break;
            }
        } else if (this.state == State.BUY) {
            if (input.equals("back")) {
                this.state = State.MENU;
            } else {
                try{
                    int coffeeTypeIndex = Integer.parseInt(input) - 1;
                    CoffeeType coffeeType = CoffeeType.values()[coffeeTypeIndex];
                    this.buy(coffeeType);
                    this.state = State.MENU;
                }
                catch (NumberFormatException ex){
                    // Do nothing -> main loop will repromt for number
                }

            }
        } else if (this.state == State.FILL) {
            this.fill(Integer.valueOf(input));
            this.fillStep++;
            if (this.fillStep > 4) {
                this.state = State.MENU;
                this.fillStep = 1;
                System.out.println();
            }
        }
    }

    private void buy(CoffeeType coffeeType) {
        if (!hasEnoughCups()) {
            System.out.println("Sorry, not enough cups!");
            System.out.println();
            return;
        }
        if (!hasEnoughWater(coffeeType)) {
            System.out.println("Sorry, not enough water!");
            System.out.println();
            return;
        }
        if (!hasEnoughMilk(coffeeType)) {
            System.out.println("Sorry, not enough milk!");
            System.out.println();
            return;
        }
        if (!hasEnoughBeans(coffeeType)) {
            System.out.println("Sorry, not enough beans!");
            System.out.println();
            return;
        }

        water -= coffeeType.getWater();
        milk -= coffeeType.getMilk();
        beans -= coffeeType.getBeans();
        money += coffeeType.getPrice();
        cups--;

        System.out.println("I have enough resources, making you a coffee!");
        System.out.println();
    }

    private void fill(int amount) {
        switch (fillStep) {
            case 1:
                water += amount;
                break;
            case 2:
                milk += amount;
                break;
            case 3:
                beans += amount;
                break;
            case 4:
                cups += amount;
                break;
        }
    }

    private void take() {
        System.out.println();
        System.out.println("I gave you $" + money);
        System.out.println();
        this.money = 0;
    }

    private void remaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.beans + " g of coffee beans");
        System.out.println(this.cups + " disposable cups");
        System.out.println("$" + this.money + " of money");
        System.out.println();
    }

    private boolean hasEnoughCups() {
        return this.cups - 1 >= 0;
    }

    private boolean hasEnoughWater(CoffeeType coffeeType) {
        return this.water - coffeeType.getWater() >= 0;
    }

    private boolean hasEnoughMilk(CoffeeType coffeeType) {
        return this.milk - coffeeType.getMilk() >= 0;
    }

    private boolean hasEnoughBeans(CoffeeType coffeeType) {
        return this.beans - coffeeType.getBeans() >= 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (true) {
            coffeeMachine.displayInstructions();

            String input = scanner.next();
            if (input.equals("exit")) {
                break;
            }

            coffeeMachine.processUserInput(input);
        }
    }
}
