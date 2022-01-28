package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        CoffeeMaker thisCoffeeMaker =
                new CoffeeMaker(400, 540, 120, 9, 550);
        MachineState thisMachine;
        CoffeeDrinks aDrink;
        // in the order of: cost, water, milk, beans, cups
        int[] resources = new int[5];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String state = scanner.nextLine();

        while (!state.equalsIgnoreCase("exit")) {
            switch (state) {
                case "buy": {
                    thisMachine = MachineState.BUY;
                    System.out.print("\nWhat do you want to buy: ");
                    System.out.println("1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeType = scanner.nextLine();
                    switch (coffeeType) {
                        case "1": {
                            aDrink = CoffeeDrinks.ESPRESSO;
                            resources = aDrink.getDrinkValues();
                        }
                        break;
                        case "2": {
                            aDrink = CoffeeDrinks.LATTE;
                            resources = aDrink.getDrinkValues();
                        }
                        break;
                        case "3": {
                            aDrink = CoffeeDrinks.CAPPUCCINO;
                            resources = aDrink.getDrinkValues();
                        }
                        break;
                        default: break;
                    }
                    thisCoffeeMaker.machineAction(thisMachine.name(), resources);
                }
                break;

                case "fill": {
                    thisMachine = MachineState.FILL;
                    resources[0] = 0; // fill command doesn't add money
                    System.out.println("\nWrite how many ml of water you want to add:");
                    resources[1] = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    resources[2] = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    resources[3] = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    resources[4] = scanner.nextInt();
                    scanner.nextLine();

                    thisCoffeeMaker.machineAction(thisMachine.name(), resources);
                }
                break;

                case "take": {
                    thisMachine = MachineState.TAKE;
                    aDrink = CoffeeDrinks.NONE;
                    System.out.println("I gave you $" + thisCoffeeMaker.money);
                    resources = aDrink.getDrinkValues();
                    resources[0] = thisCoffeeMaker.money * -1;

                    thisCoffeeMaker.machineAction(thisMachine.name(), resources);
                }
                break;

                case "remaining": {
                    thisMachine = MachineState.REMAINING;

                    thisCoffeeMaker.machineAction(thisMachine.name(), resources);
                }
                break;

                default: break;
            }

            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            state = scanner.nextLine();
        }
    }
}
