package machine;

public enum CoffeeDrinks {
    ESPRESSO(4, -250, 0, -16, -1),
    LATTE(7, -350, -75, -20, -1),
    CAPPUCCINO(6, -200, -100, -12, -1),
    NONE(0, 0, 0, 0, 0);

    private final int cost;
    private final int water;
    private final int milk;
    private final int beans;
    private final int cups;

    private CoffeeDrinks(int cost, int water, int milk, int beans, int cups) {
        this.cost = cost;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
    }

    public int[] getDrinkValues() {
        return new int[]{this.cost, this.water, this.milk, this.beans, this.cups};
    }
}
