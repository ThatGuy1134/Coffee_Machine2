package machine;

public class CoffeeMaker {
    // the resources that this type of machine holds
    int waterSupply;
    int milkSupply;
    int beansSupply;
    int cupsSupply;
    int money;

    // Setting the amount of resources a machine starts with
    public CoffeeMaker(int water, int milk, int beans, int cups, int startCash) {
        this.waterSupply = water;
        this.milkSupply = milk;
        this.beansSupply = beans;
        this.cupsSupply = cups;
        this.money = startCash;
    }

    // Determining which action the machine must perform:
    // BUY a cup of coffee, FILL the machine, TAKE out the money,
    // see the resources REMAINING in the machine, or EXIT
    public void machineAction(String machine, int[] ingredients) {
        MachineState thisMachine = MachineState.valueOf(machine);

        switch (thisMachine) {
            case BUY: this.makeCoffee(ingredients);
            break;
            case FILL:
            case TAKE:
                this.resourceAdjust(ingredients);
            break;
            case REMAINING: statusDisplay();
            break;
            case EXIT: break;
        }
    }

    // displaying a machine's current resources
    private void statusDisplay() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(this.waterSupply + " ml of water");
        System.out.println(this.milkSupply + " ml of milk");
        System.out.println(this.beansSupply + " g of coffee beans");
        System.out.println(this.cupsSupply + " disposable cups");
        System.out.println("$" + this.money + " of money");
    }

    // to make a cup of coffee, the machine first
    // needs to see if it has enough resources
    private String resourceCheck(int[] ingredients) {
        String resource;
        // the array is ordered: cost, water, milk, beans, cups
        // ths cost is positive and the res are negative
        if (this.waterSupply + ingredients[1] < 0) {
            resource = "water";
        } else if (this.milkSupply + ingredients[2] < 0) {
            resource = "milk";
        } else if (this.beansSupply + ingredients[3] < 0) {
            resource = "coffee beans";
        } else if (this.cupsSupply + ingredients[4] < 0) {
            resource = "cups";
        } else {
            resource = "enough";
        }
        return resource;
    }

    // making a cup of coffee if there are enough resources
    public void makeCoffee(int[] ingredients) {
        String resource = this.resourceCheck(ingredients);
        if (resource.equals("enough")) {
            System.out.println("I have enough resources, making you a cup of coffee!");
            this.resourceAdjust(ingredients);
        } else {
            System.out.println("Sorry, not enough " + resource + "!");
        }
    }

    // adjusting the machine's resources based on the type of coffee
    // that was made, filling the machine, or taking the money
    private void resourceAdjust(int[] ingredients) {
        this.money += ingredients[0];
        this.waterSupply += ingredients[1];
        this.milkSupply += ingredients[2];
        this.beansSupply += ingredients[3];
        this.cupsSupply += ingredients[4];
    }
}
