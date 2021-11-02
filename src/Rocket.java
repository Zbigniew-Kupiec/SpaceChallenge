public class Rocket implements SpaceShip {

    @Override
    public boolean launch() {
        return false;
    }

    @Override
    public boolean land() {
        return false;
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
