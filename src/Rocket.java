public class Rocket implements SpaceShip {
    int cost;
    int weight;
    int maxWeight;
    int curWeight;
    double launchExp;
    double landCrash;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return false;
    }

    @Override
    public boolean carry(Item item) {
        return false;
    }
}
